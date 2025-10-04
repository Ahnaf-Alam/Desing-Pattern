package org.example.entity;

import org.example.enums.ChannelType;
import org.example.enums.NotificationType;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class User {
    private final String id;
    private final String name;
    private final String email;
    private final String phoneNumber;
    private final Set<NotificationType> optOutTypes;
    private boolean globalOptOut;
    private final Map<NotificationType, Set<ChannelType>> preferences;

    public User(String id, String name, String email, String phoneNumber, Set<NotificationType> optOutTypes, Map<NotificationType, Set<ChannelType>> preferences) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.optOutTypes = optOutTypes;
        this.preferences = preferences;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Set<NotificationType> getOptOutTypes() {
        return optOutTypes;
    }

    public boolean isGlobalOptOut() {
        return globalOptOut;
    }

    public void setGlobalOptOut(boolean globalOptOut) {
        this.globalOptOut = globalOptOut;

        if(globalOptOut) {
            System.out.println(name + " opted out from all notification");
        } else {
            System.out.println(name + " opted back into notification");
        }
    }

    public Map<NotificationType, Set<ChannelType>> getPreferences() {
        return preferences;
    }

    public void subscribeToNotification(NotificationType notificationType, ChannelType channelType) {
        if(globalOptOut) {
            System.out.println(name + " is opted out");
            return;
        }

        preferences.computeIfAbsent(notificationType, k -> new HashSet<>()).add(channelType);
        optOutTypes.remove(notificationType);

        System.out.println(name + " subscribe to " + notificationType.name() + " via " + channelType.name());
    }

    public Set<ChannelType> gerPreferredChannel(NotificationType type) {
        if(globalOptOut || optOutTypes.contains(type)) {
            return Collections.emptySet();
        }

        return preferences.getOrDefault(type, Collections.emptySet());
    }
}
