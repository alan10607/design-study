package com.alan.design.pub_sub_pattern;

import com.alan.design.pub_sub_pattern.publisher.CryptoPublisher;
import com.alan.design.pub_sub_pattern.subscriber.StorageSubscriber;
import com.alan.design.pub_sub_pattern.subscriber.WebSubscriber;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.alan.design.observer_pattern.Crypto.BTC;
import static com.alan.design.observer_pattern.Crypto.ETC;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@Slf4j
class PubSubPatternTest {
    @Autowired
    private EventBus eventBus;

    @Autowired
    private WebSubscriber webSubscriber;

    @Autowired
    private StorageSubscriber storageSubscriber;

    @Autowired
    private CryptoPublisher publisher;

    @Test
    void testEventBus() {
        eventBus.subscribe(BTC, webSubscriber);
        eventBus.subscribe(BTC, storageSubscriber);
        eventBus.subscribe(ETC, webSubscriber);
        eventBus.subscribe(ETC, storageSubscriber);

        publisher.publish(BTC, 111);
        assertEquals(webSubscriber.getData(BTC).getPrice(), 111);
        assertNull(webSubscriber.getData(ETC));
        assertEquals(storageSubscriber.getData(BTC).getPrice(), 111);
        assertNull(storageSubscriber.getData(ETC));

        publisher.publish(ETC, 222);
        assertEquals(webSubscriber.getData(BTC).getPrice(), 111);
        assertEquals(webSubscriber.getData(ETC).getPrice(), 222);
        assertEquals(storageSubscriber.getData(BTC).getPrice(), 111);
        assertEquals(storageSubscriber.getData(ETC).getPrice(), 222);

        log.info("storageSubscriber unsubscribe ETC");
        eventBus.unsubscribe(ETC, storageSubscriber);
        publisher.publish(ETC, 333);
        assertEquals(webSubscriber.getData(BTC).getPrice(), 111);
        assertEquals(webSubscriber.getData(ETC).getPrice(), 333);
        assertEquals(storageSubscriber.getData(BTC).getPrice(), 111);
        assertEquals(storageSubscriber.getData(ETC).getPrice(), 222);

        log.info("storageSubscriber subscribe ETC");
        eventBus.subscribe(ETC, storageSubscriber);
        publisher.publish(ETC, 444);
        assertEquals(webSubscriber.getData(BTC).getPrice(), 111);
        assertEquals(webSubscriber.getData(ETC).getPrice(), 444);
        assertEquals(storageSubscriber.getData(BTC).getPrice(), 111);
        assertEquals(storageSubscriber.getData(ETC).getPrice(), 444);

        publisher.publish(BTC, 555);
        assertEquals(webSubscriber.getData(BTC).getPrice(), 555);
        assertEquals(webSubscriber.getData(ETC).getPrice(), 444);
        assertEquals(storageSubscriber.getData(BTC).getPrice(), 555);
        assertEquals(storageSubscriber.getData(ETC).getPrice(), 444);
    }
}