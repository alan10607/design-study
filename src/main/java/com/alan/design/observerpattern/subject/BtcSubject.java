package com.alan.design.observerpattern.subject;

import com.alan.design.observerpattern.Crypto;
import com.alan.design.observerpattern.CryptoMessage;
import org.springframework.stereotype.Component;

@Component
public class BtcSubject extends CryptoSubject {

    public void notifyPrice(int price) {
        super.notifyObservers(new CryptoMessage(Crypto.BTC, price));
    }

}
