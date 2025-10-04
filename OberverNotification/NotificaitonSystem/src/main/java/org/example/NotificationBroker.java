package org.example;

import org.example.channels.NotificationChannel;
import org.example.entity.Notification;
import org.example.entity.User;
import org.example.enums.ChannelType;
import org.example.enums.NotificationType;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NotificationBroker {
    private final Map<String, User> users;
    private final Map<NotificationType, Set<User>> subscriptions;
    private final Map<ChannelType, NotificationChannel> channelRegistery;
    private final ExecutorService executorService;
    private final Map<String, Publisher> registeredPublisher;
    private final Map<String, Notification> notificationHistory;

    public NotificationBroker() {
        this.users = new HashMap<>();
        this.subscriptions = new ConcurrentHashMap<>();
        this.channelRegistery = new ConcurrentHashMap<>();
        this.executorService = Executors.newCachedThreadPool();
        this.registeredPublisher = new ConcurrentHashMap<>();
        this.notificationHistory = new ConcurrentHashMap<>();
    }

    public void registerUser(User user) {
        this.users.put(user.getId(), user);
        System.out.println("User : " + user.getName() + " registered successfully");
    }

    public void unRegisterUser() {

    }

    public void registerPublisher(Publisher publisher) {
        this.registeredPublisher.put(publisher.getPublisherId(), publisher);
        publisher.setBroker(this);
    }

    public void unregisterPublisher(Publisher publisher){}

    public void addNotificationChannel(ChannelType channelType, NotificationChannel notificationChannel) {
        channelRegistery.put(channelType, notificationChannel);
        System.out.println("Channel -> " + channelType.name() + " added to broker");
    }

    public void subscribeUserToType(String userId, NotificationType notificationType) {
        User user = users.get(userId);

        if(user == null){

        }

        subscriptions.computeIfAbsent(notificationType, t -> Collections.newSetFromMap(new ConcurrentHashMap<>())).add(user);
    }

    public void sendNotification(Notification notification) {
        System.out.println("Sending notification -> " + notification.getTitle());

        Set<User> subscribeUsers = subscriptions.getOrDefault(notification.getType().getNotificationType(), Collections.emptySet());

        if(subscribeUsers.isEmpty()) {
            System.out.println("No Users subscribed to " + notification.getType().toString());
            return;
        }

        for (User user: subscribeUsers) {
            if(user.isGlobalOptOut()) continue;

            Set<ChannelType> preferredChannel = user.gerPreferredChannel(notification.getType().getNotificationType());

            if(preferredChannel.isEmpty()) {
                System.out.println("No preferred channels for user " + user.getName());
            }

            for (ChannelType channelType: preferredChannel) {
                NotificationChannel channel = channelRegistery.get(channelType);

                if(channel == null) {
                    System.out.println("Channel " + channelType.name() + " not registered with broker");
                    continue;
                }

                if(!channel.isChannelAvailableForUser(user)) {
                    System.out.println("Channel " + channel.getChannelName() + " unavailable for user " + user.getName());
                    continue;
                }

                executorService.submit(() -> channel.sendNotification(user, notification));
            }
        }

        notificationHistory.put(notification.getId(), notification);
    }

    public void shutdown() {
        executorService.shutdown();
    }
}
