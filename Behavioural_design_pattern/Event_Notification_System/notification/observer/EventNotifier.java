package Event_Notification_System.notification.observer;

import java.util.ArrayList;
import java.util.List;
import Event_Notification_System.utilities.Logging;

public class EventNotifier implements Subject {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
        Logging.info("User subscribed to event notifications.");
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
        Logging.info("User unsubscribed from event notifications.");
    }

    @Override
    public void notifyObservers(String eventMessage) {
        for (Observer observer : observers) {
            observer.update(eventMessage);
        }
    }

    public void notifyEvent(String eventMessage) {
        Logging.info("Event triggered: " + eventMessage);
        notifyObservers(eventMessage);
    }
}

