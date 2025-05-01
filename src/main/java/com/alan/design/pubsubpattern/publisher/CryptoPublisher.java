package com.alan.design.pubsubpattern.publisher;

import com.alan.design.observerpattern.Crypto;
import com.alan.design.observerpattern.CryptoMessage;
import com.alan.design.pubsubpattern.CryptoEvent;
import com.alan.design.pubsubpattern.EventBus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CryptoPublisher {
    private final EventBus eventBus;

    public void publish(Crypto topic, int price) {
        eventBus.post(new CryptoEvent(topic, new CryptoMessage(topic, price)));
    }

}
