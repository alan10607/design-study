package com.alan.design.creational.builder_pattern;

import lombok.Data;

@Data
public class MessageQueue {
    private final String queueName;
    private final int maxSize;
    private final boolean durable;
    private final int priority;
    private final long ttl;

    public String getQueueName() {
        return queueName;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public boolean isDurable() {
        return durable;
    }

    public int getPriority() {
        return priority;
    }

    public long getTtl() {
        return ttl;
    }

    private MessageQueue(MessageQueueBuilder builder) {
        this.queueName = builder.queueName;
        this.maxSize = builder.maxSize;
        this.durable = builder.durable;
        this.priority = builder.priority;
        this.ttl = builder.ttl;
    }

    public static class MessageQueueBuilder {
        private String queueName;
        private int maxSize;
        private boolean durable;
        private int priority;
        private long ttl;

        public MessageQueueBuilder setQueueName(String queueName) {
            this.queueName = queueName;
            return this;
        }

        public MessageQueueBuilder setMaxSize(int maxSize) {
            this.maxSize = maxSize;
            return this;
        }

        public MessageQueueBuilder setDurable(boolean durable) {
            this.durable = durable;
            return this;
        }

        public MessageQueueBuilder setPriority(int priority) {
            this.priority = priority;
            return this;
        }

        public MessageQueueBuilder setTTL(long ttl) {
            this.ttl = ttl;
            return this;
        }

        public MessageQueue build() {
            // You can add validation here
            if (ttl < 0) {
                throw new IllegalStateException("TTL should > 0");
            }

            return new MessageQueue(this);
        }
    }
}
