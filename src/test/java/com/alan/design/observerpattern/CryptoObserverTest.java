package com.alan.design.observerpattern;

import com.alan.design.observerpattern.observer.StorageObserver;
import com.alan.design.observerpattern.observer.WebObserver;
import com.alan.design.observerpattern.subject.BtcSubject;
import com.alan.design.observerpattern.subject.EtcSubject;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.alan.design.observerpattern.Crypto.BTC;
import static com.alan.design.observerpattern.Crypto.ETC;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@Slf4j
class CryptoObserverTest {
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