package com.alan.design.observer_pattern.subject;

import com.alan.design.observer_pattern.CryptoMessage;
import com.alan.design.observer_pattern.observer.CryptoObserver;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public abstract class CryptoSubject {
    private final List<CryptoObserver> observers = new ArrayList<>();

    public void registerObserver(CryptoObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(CryptoObserver observer) {
        observers.remove(observer);
    }

    protected void notifyObservers(CryptoMessage message) {
        observers.forEach(observer -> observer.receive(message));
    }

}
