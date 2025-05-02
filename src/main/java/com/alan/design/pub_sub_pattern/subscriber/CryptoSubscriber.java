package com.alan.design.pub_sub_pattern.subscriber;

import com.alan.design.observer_pattern.CryptoMessage;

public interface CryptoSubscriber {
    void receive(CryptoMessage message);

}