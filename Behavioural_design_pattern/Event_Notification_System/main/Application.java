package Event_Notification_System.main;

import  Event_Notification_System.notification.observer.*;
import  Event_Notification_System.notification.strategy.*;
import  Event_Notification_System.utilities.*;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create Event Notifier (Observer Pattern)
        EventNotifier notifier = new EventNotifier();

        // Subscribe users with different notification strategies (Strategy Pattern)
        User alice = new User("Alice", new SMSNotification());
        User bob = new User("Bob", new EmailNotification());
        User charlie = new User("Charlie", new PushNotification());

        notifier.subscribe(alice);
        notifier.subscribe(bob);
        notifier.subscribe(charlie);

        while (true) {
            System.out.println("Enter event message (or type 'exit' to quit):");
            String eventMessage = scanner.nextLine();

            if ("exit".equalsIgnoreCase(eventMessage)) {
                Logging.info("Exiting the system.");
                break;
            }

            notifier.notifyEvent(eventMessage);
        }

        scanner.close();
    }
}
