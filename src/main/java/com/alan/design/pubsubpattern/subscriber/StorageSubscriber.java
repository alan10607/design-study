package com.alan.design.pubsubpattern.subscriber;

import com.alan.design.observerpattern.Crypto;
import com.alan.design.observerpattern.CryptoMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class StorageSubscriber implements CryptoSubscriber {
    private final Map<Crypto, CryptoMessage> data = new HashMap<>(); // mock data to test

    @Override
    public void receive(CryptoMessage message) {
        data.put(message.getCrypto(), message);
        log.info("Storage subscriber receive {} message {}", message.getCrypto(), message);
    }

    public CryptoMessage getData(Crypto crypto) {
        return data.get(crypto);
    }
}
