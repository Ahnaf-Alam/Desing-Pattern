package org.example.channels;

import org.example.entity.Notification;
import org.example.entity.User;
import org.example.enums.ChannelType;

public class EmailChannel implements NotificationChannel {

    private String provider;
    private String email;

    public EmailChannel(String provider, String email) {
        this.provider = provider;
        this.email = email;
    }

    @Override
    public String getChannelName() {
        return ChannelType.EMAIL.toString();
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
        return user.getEmail() != null && !user.getName().isEmpty();
    }
}
