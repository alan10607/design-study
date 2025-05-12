package com.alan.design.structural.bridge_pattern.abstraction;

import com.alan.design.structural.bridge_pattern.Message;
import com.alan.design.structural.bridge_pattern.implementator.MessageSender;

public abstract class NotificationService {
    private final MessageSender messageSender;

    public NotificationService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    protected String notify(Message message) {
        return messageSender.send(message);
    }

    public abstract String notify(String body);
}
