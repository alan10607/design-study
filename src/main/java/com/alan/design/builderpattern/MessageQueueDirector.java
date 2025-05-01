package com.alan.design.builderpattern;

import org.springframework.stereotype.Service;

@Service
public class MessageQueueDirector {

    public MessageQueue buildDefaultQueue() {
        return new MessageQueue.MessageQueueBuilder()
                .setQueueName("DefaultQueue")
                .setMaxSize(1000)
                .setDurable(true)
                .setPriority(5)
                .setTTL(3600)
                .build();
    }

    public MessageQueue buildHighPriorityQueue() {
        return new MessageQueue.MessageQueueBuilder()
                .setQueueName("HighPriorityQueue")
                .setMaxSize(500)
                .setDurable(true)
                .setPriority(10)
                .setTTL(1800)
                .build();
    }

    public MessageQueue buildNonDurableQueue() {
        return new MessageQueue.MessageQueueBuilder()
                .setQueueName("NonDurableQueue")
                .setMaxSize(200)
                .setDurable(false)
                .setPriority(3)
                .setTTL(600)
                .build();
    }
}
