package com.alan.design.structural.bridge_pattern.implementator;

import com.alan.design.structural.bridge_pattern.Message;

public class WebSender implements MessageSender {

    @Override
    public String send(Message message) {
        // skip detail
        return String.format("Web message: level=%s, body=%s", message.getLevel(), message.getBody());
    }
}
