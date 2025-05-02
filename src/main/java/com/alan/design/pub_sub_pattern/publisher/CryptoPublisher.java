package com.alan.design.pub_sub_pattern.publisher;

import com.alan.design.observer_pattern.Crypto;
import com.alan.design.observer_pattern.CryptoMessage;
import com.alan.design.pub_sub_pattern.CryptoEvent;
import com.alan.design.pub_sub_pattern.EventBus;
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
