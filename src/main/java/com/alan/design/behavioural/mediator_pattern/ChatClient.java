package com.alan.design.behavioural.mediator_pattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ChatClient implements Colleague {
    private final ChatRoom chatRoom;
    private final String name;
    private String receivedMessage = "";

    public ChatClient(ChatRoom chatRoom, String name) {
        this.chatRoom = chatRoom;
        this.name = name;
    }

    @Override
    public void send(String message) {
        log.info("Client {} send message: {}", name, message);
        chatRoom.sendMessage(message, this);
    }

    @Override
    public void receive(String message) {
        log.info("Client {} receive message: {}", name, message);
        receivedMessage = message;
        //skip detail
    }

    public String getReceivedMessage() {
        return receivedMessage;
    }
}

