package com.alan.design.structural.bridge_pattern.abstraction;

import com.alan.design.structural.bridge_pattern.Message;
import com.alan.design.structural.bridge_pattern.MessageLevel;
import com.alan.design.structural.bridge_pattern.implementator.MessageSender;

public class HighPriorityNotificationService extends NotificationService {

    public HighPriorityNotificationService(MessageSender messageSender) {
        super(messageSender);
    }

    @Override
    public String notify(String body) {
        return notify(new Message(MessageLevel.HIGH_PRIORITY, body));
    }


}
