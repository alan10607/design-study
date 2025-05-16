package com.alan.design.behavioural.mediator_pattern;

public interface Colleague {
    void send(String message);

    void receive(String message);
}