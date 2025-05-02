package com.alan.design.observer_pattern;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CryptoMessage {
    private Crypto crypto;
    private int price;
}
