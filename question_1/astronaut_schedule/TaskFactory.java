public class TaskFactory {
    public static Task createTask(String description, String startTime, String endTime, String priority) throws InvalidTimeException {
        if (!isValidTime(startTime) || !isValidTime(endTime)) {
            throw new InvalidTimeException("Invalid time format for task: " + description);
        }
        return new Task(description, startTime, endTime, priority);
    }

    private static boolean isValidTime(String time) {
        // Simple validation for 24-hour format HH:mm
        return time.matches("^([01]?\\d|2[0-3]):[0-5]\\d$");
    }
}
