import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class ScheduleManager {
    private static ScheduleManager instance = null;
    private List<Task> tasks;
    private List<TaskObserver> observers;

    private ScheduleManager() {
        tasks = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void addObserver(TaskObserver observer) {
        observers.add(observer);
    }

    public void addTask(String description, String startTime, String endTime, String priority) throws Exception {
        Task newTask = TaskFactory.createTask(description, startTime, endTime, priority);

        for (Task task : tasks) {
            if (isConflict(task, newTask)) {
                notifyObservers(newTask);
                throw new TaskConflictException("Task conflicts with existing task: " + task.getDescription());
            }
        }

        tasks.add(newTask);
        Collections.sort(tasks, (t1, t2) -> t1.getStartTime().compareTo(t2.getStartTime()));
    }

    public void removeTask(String description) throws TaskNotFoundException {
        Task taskToRemove = tasks.stream()
                .filter(task -> task.getDescription().equals(description))
                .findFirst()
                .orElseThrow(() -> new TaskNotFoundException("Task not found: " + description));
        tasks.remove(taskToRemove);
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
        } else {
            tasks.forEach(System.out::println);
        }
    }

    private boolean isConflict(Task existingTask, Task newTask) {
        return !(newTask.getEndTime().compareTo(existingTask.getStartTime()) <= 0 ||
                 newTask.getStartTime().compareTo(existingTask.getEndTime()) >= 0);
    }

    private void notifyObservers(Task task) {
        for (TaskObserver observer : observers) {
            observer.update(task);
        }
    }
}
