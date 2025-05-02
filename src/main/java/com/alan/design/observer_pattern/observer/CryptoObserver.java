package com.alan.design.observer_pattern.observer;

import com.alan.design.observer_pattern.CryptoMessage;

public interface CryptoObserver {
    void receive(CryptoMessage message);

}
