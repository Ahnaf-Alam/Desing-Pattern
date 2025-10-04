package org.example;

import java.util.Map;

public interface Publisher {
    String getName();
    String getPublisherId();
    void setBroker(NotificationBroker broker);
    void publishNotification(NotificationType type, String title, String conent,
                             Map<String, String> personalizeData);
    void start();
    void stop();
}
