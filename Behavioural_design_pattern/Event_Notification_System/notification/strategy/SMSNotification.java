package Event_Notification_System.notification.strategy;

import NOTIFICATION.utilities.Logging;

public class SMSNotification implements NotificationStrategy {
    @Override
    public void notifyUser(String message) {
        Logging.info("Sending SMS notification: " + message);
    }
}
