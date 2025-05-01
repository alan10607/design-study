package com.alan.design.observerpattern.subject;

import com.alan.design.observerpattern.Crypto;
import com.alan.design.observerpattern.CryptoMessage;
import org.springframework.stereotype.Component;

@Component
public class EtcSubject extends CryptoSubject {

    public void notifyObservers(int price) {
        super.notifyObservers(new CryptoMessage(Crypto.ETC, price));
    }

}
