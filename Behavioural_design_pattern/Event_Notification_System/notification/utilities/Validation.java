package Event_Notification_System.utilities;

public class Validation {

   
    public static void validateString(String str, String errorMessage) {
        if (str == null || str.trim().isEmpty()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    
    public static void validateIntegerInRange(int value, int min, int max, String errorMessage) {
        if (value < min || value > max) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

   
    public static void validateNotNull(Object obj, String errorMessage) {
        if (obj == null) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
