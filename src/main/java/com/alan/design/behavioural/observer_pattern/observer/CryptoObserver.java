package com.alan.design.behavioural.observer_pattern.observer;

import com.alan.design.behavioural.observer_pattern.CryptoMessage;

public interface CryptoObserver {
    void receive(CryptoMessage message);

}
