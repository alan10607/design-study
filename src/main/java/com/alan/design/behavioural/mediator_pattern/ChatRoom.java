package com.alan.design.behavioural.mediator_pattern;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ChatRoom implements Mediator {

    private final List<ChatClient> clients = new ArrayList<>();

    public void addClient(ChatClient client) {
        this.clients.add(client);
    }

    public void removeClient(ChatClient client) {
        this.clients.remove(client);
    }

    @Override
    public void sendMessage(String message, ChatClient sender) {
        if (!clients.contains(sender)) {
            throw new IllegalStateException("Client not in chat room");
        }

        clients.stream().filter(client -> !client.equals(sender))
                .forEach(client -> client.receive(message));
    }
}