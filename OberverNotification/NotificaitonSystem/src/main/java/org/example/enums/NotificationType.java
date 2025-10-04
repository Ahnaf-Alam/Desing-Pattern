package org.example.enums;

public enum NotificationType {
    NEW_MESSAGE,
    FRIEND_REQUEST,
    SECURITY_ALERT;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
