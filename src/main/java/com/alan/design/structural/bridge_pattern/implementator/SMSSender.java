package com.alan.design.structural.bridge_pattern.implementator;

import com.alan.design.structural.bridge_pattern.Message;

public class SMSSender implements MessageSender {

    @Override
    public String send(Message message) {
        // skip detail
        return String.format("SMS message: level=%s, body=%s", message.getLevel(), message.getBody());
    }
}
