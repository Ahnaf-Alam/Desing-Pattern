package org.example.channels;

import org.example.entity.Notification;
import org.example.entity.User;
import org.example.enums.ChannelType;
import org.example.enums.NotificationType;

public class PushChannel implements NotificationChannel{
    @Override
    public String getChannelName() {
        return ChannelType.PUSH.toString();
    }

    @Override
    public boolean sendNotification(User user, Notification notification) {
        System.out.println("Notification is send to " + user.getName());
        System.out.println("Notification: " + notification.getTitle());
        System.out.println("content: " + notification.getPersonalizationData());

        return true;
    }

    @Override
    public boolean isChannelAvailableForUser(User user) {
        return false;
    }
}
