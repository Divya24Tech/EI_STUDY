package com.companyname.notification.observer;

import com.companyname.notification.strategy.NotificationStrategy;
import com.companyname.utilities.Logging;

public class User implements Observer {
    private String name;
    private NotificationStrategy notificationStrategy;

    public User(String name, NotificationStrategy strategy) {
        this.name = name;
        this.notificationStrategy = strategy;
    }

    @Override
    public void update(String eventMessage) {
        Logging.info(name + " received event notification: " + eventMessage);
        notificationStrategy.notifyUser(eventMessage);
    }
}
