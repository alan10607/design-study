package com.alan.design.behavioural.mediator_pattern;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Slf4j
class MediatorPatternTest {
    @Autowired
    private ChatRoom chatRoom;

    @Test
    void testChatRoom() {
        ChatClient client1 = new ChatClient(chatRoom, "Client 1");
        ChatClient client2 = new ChatClient(chatRoom, "Client 2");
        ChatClient client3 = new ChatClient(chatRoom, "Client 3");
        ChatClient client4 = new ChatClient(chatRoom, "Client 4");

        log.info("client1, client2, client3 join chat room");
        chatRoom.addClient(client1);
        chatRoom.addClient(client2);
        chatRoom.addClient(client3);

        log.info("Test client2 send message:");
        client2.send("Hello");
        assertEquals(client1.getReceivedMessage(), "Hello");
        assertEquals(client2.getReceivedMessage(), "");
        assertEquals(client3.getReceivedMessage(), "Hello");
        assertEquals(client4.getReceivedMessage(), "");

        log.info("Test client3 send message:");
        client3.send("Hi");
        assertEquals(client1.getReceivedMessage(), "Hi");
        assertEquals(client2.getReceivedMessage(), "Hi");
        assertEquals(client3.getReceivedMessage(), "Hello");
        assertEquals(client4.getReceivedMessage(), "");

        log.info("client3 leave chat room");
        chatRoom.removeClient(client3);

        log.info("Test client1 send message:");
        client1.send("Why client3 leave?");
        assertEquals(client1.getReceivedMessage(), "Hi");
        assertEquals(client2.getReceivedMessage(), "Why client3 leave?");
        assertEquals(client3.getReceivedMessage(), "Hello");
        assertEquals(client4.getReceivedMessage(), "");

        log.info("Test client4 (not chat room) send message:");
        assertThrows(IllegalStateException.class, () -> client4.send("Wow"), "Client not in chat room");
        assertEquals(client1.getReceivedMessage(), "Hi");
        assertEquals(client2.getReceivedMessage(), "Why client3 leave?");
        assertEquals(client3.getReceivedMessage(), "Hello");
        assertEquals(client4.getReceivedMessage(), "");
    }

}
