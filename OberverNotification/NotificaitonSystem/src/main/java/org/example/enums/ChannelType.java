package org.example.enums;

public enum ChannelType {
    EMAIL,
    SMS,
    PUSH,
    IN_APP;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
