package com.alan.design.observer_pattern.observer;

import com.alan.design.observer_pattern.Crypto;
import com.alan.design.observer_pattern.CryptoMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class StorageObserver implements CryptoObserver {
    private final Map<Crypto, CryptoMessage> data = new HashMap<>(); // mock data to test

    @Override
    public void receive(CryptoMessage message) {
        data.put(message.getCrypto(), message);
        log.info("Storage observer receive {} message {}", message.getCrypto(), message);
    }

    public CryptoMessage getData(Crypto crypto) {
        return data.get(crypto);
    }
}
