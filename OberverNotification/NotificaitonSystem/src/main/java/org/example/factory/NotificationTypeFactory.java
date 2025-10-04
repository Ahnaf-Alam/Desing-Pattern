package org.example.factory;

import org.example.FriendRequestNotification;
import org.example.MessageNotification;
import org.example.NotificationType;

public class NotificationTypeFactory {
    public static NotificationType get(org.example.enums.NotificationType type) {
        switch (type) {
            case NEW_MESSAGE -> {
                return new MessageNotification();
            }
            case FRIEND_REQUEST -> {
                new FriendRequestNotification();
            }
            default -> throw new IllegalArgumentException("Unsupported notification type");
        }

        return null;
    }
}
