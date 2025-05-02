package com.alan.design.builder_pattern;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class BuilderPatternTest {
    @Autowired
    private MessageQueueDirector director;

    @Test
    void testMessageQueueDirector() {
        MessageQueue defaultMQ = director.buildDefaultQueue();
        MessageQueue highPriorityMQ = director.buildHighPriorityQueue();
        MessageQueue nonDurableMQ = director.buildNonDurableQueue();

        assertEquals("DefaultQueue", defaultMQ.getQueueName());
        assertEquals(1000, defaultMQ.getMaxSize());
        assertEquals(true, defaultMQ.isDurable());
        assertEquals(5, defaultMQ.getPriority());
        assertEquals(3600, defaultMQ.getTtl());

        assertEquals("HighPriorityQueue", highPriorityMQ.getQueueName());
        assertEquals(500, highPriorityMQ.getMaxSize());
        assertEquals(true, highPriorityMQ.isDurable());
        assertEquals(10, highPriorityMQ.getPriority());
        assertEquals(1800, highPriorityMQ.getTtl());

        assertEquals("NonDurableQueue", nonDurableMQ.getQueueName());
        assertEquals(200, nonDurableMQ.getMaxSize());
        assertEquals(false, nonDurableMQ.isDurable());
        assertEquals(3, nonDurableMQ.getPriority());
        assertEquals(600, nonDurableMQ.getTtl());
    }
}