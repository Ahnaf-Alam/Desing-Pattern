package org.example;

import org.example.entity.User;

public class FriendRequestNotification implements NotificationType {
    @Override
    public org.example.enums.NotificationType getNotificationType() {
        return org.example.enums.NotificationType.FRIEND_REQUEST;
    }

    @Override
    public String formatContent(String conent, User user) {
        return NotificationType.super.formatContent(conent, user);
    }

    @Override
    public boolean hasSpecializeDeliveryContent() {
        return NotificationType.super.hasSpecializeDeliveryContent();
    }
}
