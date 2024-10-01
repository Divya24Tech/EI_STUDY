public class ConflictObserver implements TaskObserver {
    @Override
    public void update(Task task) {
        System.out.println("Conflict detected with task: " + task.getDescription());
    }
}
