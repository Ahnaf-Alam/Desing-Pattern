package org.example.channels;

import org.example.entity.Notification;
import org.example.entity.User;

public interface NotificationChannel {
    String getChannelName();
    boolean sendNotification(User user, Notification notification);
    boolean isChannelAvailableForUser(User user);
}
