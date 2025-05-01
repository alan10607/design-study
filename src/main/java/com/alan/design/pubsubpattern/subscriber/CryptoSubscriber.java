package com.alan.design.pubsubpattern.subscriber;

import com.alan.design.observerpattern.CryptoMessage;

public interface CryptoSubscriber {
    void receive(CryptoMessage message);

}