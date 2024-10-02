package behavioral_patterns.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ConcreteSubject implements Subject {
    private static final Logger logger = Logger.getLogger(ConcreteSubject.class.getName());
    private List<Observer> observers = new ArrayList<>();
    private String eventState;

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
        logger.info("Observer registered: " + observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
        logger.info("Observer removed: " + observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(eventState);
        }
    }

    public void setEventState(String state) {
        this.eventState = state;
        notifyObservers();
    }
}
