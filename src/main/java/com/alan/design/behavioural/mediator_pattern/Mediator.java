package com.alan.design.behavioural.mediator_pattern;

public interface Mediator {
    void sendMessage(String message, ChatClient client);
}