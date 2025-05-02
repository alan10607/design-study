package com.alan.design.observer_pattern.subject;

import com.alan.design.observer_pattern.Crypto;
import com.alan.design.observer_pattern.CryptoMessage;
import org.springframework.stereotype.Component;

@Component
public class EtcSubject extends CryptoSubject {

    public void notifyPrice(int price) {
        super.notifyObservers(new CryptoMessage(Crypto.ETC, price));
    }

}
