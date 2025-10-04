package org.example.publishers;

import org.example.NotificationBroker;
import org.example.NotificationType;
import org.example.Publisher;
import org.example.entity.Notification;

import java.util.Map;
import java.util.UUID;

public class NotificationPublisher implements Publisher {
    private final String id;
    private final String name;
    private NotificationBroker broker;
    private boolean isActive = false;

    public NotificationPublisher(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getPublisherId() {
        return this.id;
    }

    @Override
    public void setBroker(NotificationBroker broker) {
        this.broker = broker;
    }

    @Override
    public void publishNotification(NotificationType type, String title, String conent, Map<String, String> personalizeData) {
        if(broker != null && isActive) {
            Notification notification = new Notification(
                    UUID.randomUUID().toString(),
                    type,
                    title,
                    conent,
                    personalizeData,
                    null
            );

            broker.sendNotification(notification);
        }
    }

    @Override
    public void start() {
        isActive = true;
        System.out.println(" " + name + " started successfully");
    }

    @Override
    public void stop() {
        isActive = false;
        System.out.println(" " + name + " stopped successfully");
    }
}
