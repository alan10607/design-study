package com.alan.design.structural.bridge_pattern.implementator;

import com.alan.design.structural.bridge_pattern.Message;

public interface MessageSender {
    String send(Message message);
}