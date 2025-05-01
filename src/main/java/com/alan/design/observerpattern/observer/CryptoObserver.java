package com.alan.design.observerpattern.observer;

import com.alan.design.observerpattern.CryptoMessage;

public interface CryptoObserver {
    void receive(CryptoMessage message);

}
