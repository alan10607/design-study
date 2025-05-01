package com.alan.design.pubsubpattern;

import com.alan.design.observerpattern.Crypto;
import com.alan.design.pubsubpattern.subscriber.CryptoSubscriber;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class EventBus {
    private final Map<Crypto, List<CryptoSubscriber>> subscriberMap = new HashMap<>();

    public void subscribe(Crypto topic, CryptoSubscriber subscriber) {
        subscriberMap.computeIfAbsent(topic, key -> new ArrayList<>()).add(subscriber);
    }

    public void unsubscribe(Crypto topic, CryptoSubscriber subscriber) {
        List<CryptoSubscriber> subscribers = subscriberMap.get(topic);
        if (subscribers != null) {
            subscribers.remove(subscriber);
            if (subscribers.isEmpty()) {
                subscriberMap.remove(topic);
            }
        }
    }

    public void post(CryptoEvent event) {
        List<CryptoSubscriber> subscribers = subscriberMap.get(event.getTopic());
        if (subscribers != null) {
            subscribers.forEach(subscriber -> subscriber.receive(event.getMessage()));
        }
    }

}
