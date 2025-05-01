package com.alan.design.observerpattern;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CryptoMessage {
    private Crypto crypto;
    private int price;
}
