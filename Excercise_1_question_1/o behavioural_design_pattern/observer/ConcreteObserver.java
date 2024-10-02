package behavioral_patterns.observer;

import java.util.logging.Logger;

public class ConcreteObserver implements Observer {
    private static final Logger logger = Logger.getLogger(ConcreteObserver.class.getName());
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String eventState) {
        logger.info(name + " received update: " + eventState);
    }
}
