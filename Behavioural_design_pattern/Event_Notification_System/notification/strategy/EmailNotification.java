package Event_Notification_System.notification.strategy;

import NOTIFICATION.utilities.Logging;

public class EmailNotification implements NotificationStrategy {
    @Override
    public void notifyUser(String message) {
        Logging.info("Sending Email notification: " + message);
    }
}
