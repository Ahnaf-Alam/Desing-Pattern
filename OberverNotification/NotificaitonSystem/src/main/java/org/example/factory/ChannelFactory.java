package org.example.factory;

import org.example.channels.EmailChannel;
import org.example.channels.NotificationChannel;
import org.example.channels.PushChannel;
import org.example.channels.SMSChannel;
import org.example.enums.ChannelType;

public class ChannelFactory {
    public static NotificationChannel create(ChannelType type) {
        switch (type) {
            case SMS -> {
                return new SMSChannel("twilio", "api-key");
            }
            case EMAIL -> {
                return new EmailChannel("SMTP", "testUser@gmail.com");
            }
            case PUSH -> {
                return new PushChannel();
            }
            default -> throw new IllegalArgumentException("Unsupported channel type: " + type);
        }
    }
}
