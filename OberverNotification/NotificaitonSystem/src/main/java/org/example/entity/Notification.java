package org.example.entity;

import org.example.NotificationType;

import java.time.LocalDateTime;
import java.util.Map;

public class Notification {
    private final String id;
    private final NotificationType type;
    private final String title;
    private final String content;
    private final Map<String, String> personalizationData;
    private final User sender;
    private LocalDateTime createdAt;

    public Notification(String id, NotificationType type, String title, String content, Map<String, String> personalizationData, User sender) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.content = content;
        this.personalizationData = personalizationData;
        this.sender = sender;
    }

    public String getId() {
        return id;
    }

    public NotificationType getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Map<String, String> getPersonalizationData() {
        return personalizationData;
    }

    public User getSender() {
        return sender;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getPersonalizationContent(User recipient) {
        String content = this.content;
        content = content.replace("{userName}", recipient.getName());
        content = content.replace("{userEmail}", recipient.getEmail());

        for(Map.Entry<String, String> entry: personalizationData.entrySet()) {
            content = content.replace("{" + entry.getKey() + "}", entry.getValue());
        }

        return this.type.formatContent(content, recipient);
    }
}
