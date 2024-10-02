
package E-Commerce_Discount_System.utilities;

public class Validation {
    public static void validateString(String str, String errorMessage) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
