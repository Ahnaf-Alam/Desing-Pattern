package org.example.channels;

import org.example.entity.Notification;
import org.example.entity.User;
import org.example.enums.ChannelType;

public class SMSChannel implements NotificationChannel {
    private String provider;
    private String apiKey;

    public SMSChannel(String provider, String apKey) {
        this.provider = provider;
        this.apiKey = apKey;
    }
    @Override
    public String getChannelName() {
        return ChannelType.SMS.toString();
    }

    @Override
    public boolean sendNotification(User user, Notification notification) {
        if(user.getPhoneNumber() == null || user.getPhoneNumber().isBlank()) {
            System.out.println("No phone number is found for user " + user.getName());
            return false;
        }
        try {
            Thread.sleep(250); // for network latency
            String personalizeContent = notification.getPersonalizationContent(user);
            System.out.println("[SMS via " + provider + "] to " + user.getPhoneNumber() + ": " + personalizeContent);
            return true;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("SMS sending failed for user " + user.getName());
            return false;
        }
    }

    @Override
    public boolean isChannelAvailableForUser(User user) {
        return false;
    }
}
