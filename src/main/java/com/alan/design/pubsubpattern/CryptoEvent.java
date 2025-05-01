package com.alan.design.pubsubpattern;

import com.alan.design.observerpattern.Crypto;
import com.alan.design.observerpattern.CryptoMessage;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CryptoEvent {
    private Crypto topic;
    private CryptoMessage message;

}
