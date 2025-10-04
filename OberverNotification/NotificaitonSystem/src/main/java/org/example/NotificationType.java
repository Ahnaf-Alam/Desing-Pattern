package org.example;

import org.example.entity.User;

public interface NotificationType {
    org.example.enums.NotificationType getNotificationType();

    default String formatContent(String conent, User user) {
        return conent;
    }

    default boolean hasSpecializeDeliveryContent() {
        return false;
    }
}
