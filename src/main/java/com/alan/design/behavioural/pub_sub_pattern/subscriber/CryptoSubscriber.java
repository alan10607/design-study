package com.alan.design.behavioural.pub_sub_pattern.subscriber;

import com.alan.design.behavioural.observer_pattern.CryptoMessage;

public interface CryptoSubscriber {
    void receive(CryptoMessage message);

}