package com.alan.design.behavioural.observer_pattern.subject;

import com.alan.design.behavioural.observer_pattern.CryptoMessage;
import com.alan.design.behavioural.observer_pattern.Crypto;
import org.springframework.stereotype.Component;

@Component
public class EtcSubject extends CryptoSubject {

    public void notifyPrice(int price) {
        super.notifyObservers(new CryptoMessage(Crypto.ETC, price));
    }

}
