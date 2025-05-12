package com.alan.design.structural.bridge_pattern.abstraction;

import com.alan.design.structural.bridge_pattern.Message;
import com.alan.design.structural.bridge_pattern.MessageLevel;
import com.alan.design.structural.bridge_pattern.implementator.MessageSender;

public class NormalNotificationService extends NotificationService {

    public NormalNotificationService(MessageSender messageSender) {
        super(messageSender);
    }

    @Override
    public String notify(String body) {
        return notify(new Message(MessageLevel.NORMAL, body));
    }


}
