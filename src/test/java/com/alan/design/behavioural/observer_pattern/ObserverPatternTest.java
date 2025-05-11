package com.alan.design.behavioural.observer_pattern;

import com.alan.design.behavioural.observer_pattern.observer.StorageObserver;
import com.alan.design.behavioural.observer_pattern.observer.WebObserver;
import com.alan.design.behavioural.observer_pattern.subject.BtcSubject;
import com.alan.design.behavioural.observer_pattern.subject.EtcSubject;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.alan.design.behavioural.observer_pattern.Crypto.BTC;
import static com.alan.design.behavioural.observer_pattern.Crypto.ETC;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@Slf4j
class ObserverPatternTest {
    @Autowired
    private BtcSubject btcSubject;

    @Autowired
    private EtcSubject etcSubject;

    @Autowired
    private WebObserver webObserver;

    @Autowired
    private StorageObserver storageObserver;

    @Test
    void testCryptoObserver() {
        btcSubject.registerObserver(webObserver);
        btcSubject.registerObserver(storageObserver);
        etcSubject.registerObserver(webObserver);
        etcSubject.registerObserver(storageObserver);

        btcSubject.notifyPrice(111);
        assertEquals(webObserver.getData(BTC).getPrice(), 111);
        assertNull(webObserver.getData(ETC));
        assertEquals(storageObserver.getData(BTC).getPrice(), 111);
        assertNull(storageObserver.getData(ETC));

        etcSubject.notifyPrice(222);
        assertEquals(webObserver.getData(BTC).getPrice(), 111);
        assertEquals(webObserver.getData(ETC).getPrice(), 222);
        assertEquals(storageObserver.getData(BTC).getPrice(), 111);
        assertEquals(storageObserver.getData(ETC).getPrice(), 222);

        log.info("Remove storageObserver form etcSubject");
        etcSubject.removeObserver(storageObserver);
        etcSubject.notifyPrice(333);
        assertEquals(webObserver.getData(BTC).getPrice(), 111);
        assertEquals(webObserver.getData(ETC).getPrice(), 333);
        assertEquals(storageObserver.getData(BTC).getPrice(), 111);
        assertEquals(storageObserver.getData(ETC).getPrice(), 222);

        log.info("Add storageObserver to etcSubject");
        etcSubject.registerObserver(storageObserver);
        etcSubject.notifyPrice(444);
        assertEquals(webObserver.getData(BTC).getPrice(), 111);
        assertEquals(webObserver.getData(ETC).getPrice(), 444);
        assertEquals(storageObserver.getData(BTC).getPrice(), 111);
        assertEquals(storageObserver.getData(ETC).getPrice(), 444);

        btcSubject.notifyPrice(555);
        assertEquals(webObserver.getData(BTC).getPrice(), 555);
        assertEquals(webObserver.getData(ETC).getPrice(), 444);
        assertEquals(storageObserver.getData(BTC).getPrice(), 555);
        assertEquals(storageObserver.getData(ETC).getPrice(), 444);
    }
}