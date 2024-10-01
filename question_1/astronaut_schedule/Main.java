public class Main {
    public static void main(String[] args) {
        ScheduleManager scheduleManager = ScheduleManager.getInstance();
        Logger logger = Logger.getInstance();

        // Example of adding tasks
        try {
            scheduleManager.addTask("Morning Exercise", "07:00", "08:00", "High");
            scheduleManager.addTask("Team Meeting", "09:00", "10:00", "Medium");
            scheduleManager.viewTasks();
        } catch (Exception e) {
            logger.logError(e.getMessage());
        }
    }
}
