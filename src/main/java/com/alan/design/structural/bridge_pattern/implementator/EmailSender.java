package com.alan.design.structural.bridge_pattern.implementator;

import com.alan.design.structural.bridge_pattern.Message;

public class EmailSender implements MessageSender {

    @Override
    public String send(Message message) {
        // skip detail
        return String.format("Email message: level=%s, body=%s", message.getLevel(), message.getBody());
    }
}
