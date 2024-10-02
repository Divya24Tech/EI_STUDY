package Event_Notification_System.utilities;

import java.time.LocalDateTime;

public class Logging {

    public static void info(String message) {
        System.out.println("INFO [" + LocalDateTime.now() + "]: " + message);
    }

    public static void error(String message) {
        System.out.println("ERROR [" + LocalDateTime.now() + "]: " + message);
    }
}
