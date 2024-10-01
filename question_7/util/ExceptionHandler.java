package util;

public class ExceptionHandler {
    public static void handleException(Exception e) {
        LoggerUtil.logError("An error occurred: " + e.getMessage());
        e.printStackTrace();
    }
}
