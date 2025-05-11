package com.alan.design.behavioural.observer_pattern.observer;

import com.alan.design.behavioural.observer_pattern.Crypto;
import com.alan.design.behavioural.observer_pattern.CryptoMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class WebObserver implements CryptoObserver {
    private final Map<Crypto, CryptoMessage> data = new HashMap<>(); // mock data to test

    @Override
    public void receive(CryptoMessage message) {
        data.put(message.getCrypto(), message);
        log.info("Web observer receive {} message {}", message.getCrypto(), message);
    }

    public CryptoMessage getData(Crypto crypto) {
        return data.get(crypto);
    }
}
