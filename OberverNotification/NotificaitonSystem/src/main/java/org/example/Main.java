package org.example;

import org.example.entity.User;
import org.example.enums.ChannelType;
import org.example.factory.ChannelFactory;
import org.example.factory.NotificationTypeFactory;
import org.example.publishers.NotificationPublisher;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        NotificationBroker notificationBroker = new NotificationBroker();

        for (ChannelType channelType: ChannelType.values()) {
            try {
                notificationBroker.addNotificationChannel(channelType, ChannelFactory.create(channelType));
            } catch (IllegalArgumentException e) {

            }

            User alice = new User(
                    UUID.randomUUID().toString(),
                    "Alice",
                    "alice@example.com",
                    "+11111111",
                    new HashSet<>(),
                    new HashMap<>()
            );

            User bob = new User(
                    UUID.randomUUID().toString(),
                    "Bob",
                    "bob@example.com",
                    "+222222222",
                    new HashSet<>(),
                    new HashMap<>()
            );

            notificationBroker.registerUser(alice);
            notificationBroker.registerUser(bob);

            NotificationType messageType = NotificationTypeFactory.get(org.example.enums.NotificationType.NEW_MESSAGE);
            NotificationType friendRequest = NotificationTypeFactory.get(org.example.enums.NotificationType.FRIEND_REQUEST);

            alice.subscribeToNotification(org.example.enums.NotificationType.NEW_MESSAGE, ChannelType.EMAIL);
            alice.subscribeToNotification(org.example.enums.NotificationType.NEW_MESSAGE, ChannelType.SMS);
            bob.subscribeToNotification(org.example.enums.NotificationType.FRIEND_REQUEST, ChannelType.PUSH);


            notificationBroker.subscribeUserToType(alice.getId(), org.example.enums.NotificationType.NEW_MESSAGE);
            notificationBroker.subscribeUserToType(bob.getId(), org.example.enums.NotificationType.FRIEND_REQUEST);

            NotificationPublisher publisher = new NotificationPublisher("pub-1", "CorePublisher");
            notificationBroker.registerPublisher(publisher);
            publisher.start();

            Map<String, String> data = new HashMap<>();
            data.put("userName", "Alice");
            data.put("userEmail", "alice@example.com");

            publisher.publishNotification(messageType, "New DM", "Hello {username}, you have a new direct message", data);
            publisher.publishNotification(friendRequest, "New Friend request send", "{username} you have got new friend request", Collections.emptyMap());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }

            publisher.stop();
            notificationBroker.shutdown();
        }
    }
}