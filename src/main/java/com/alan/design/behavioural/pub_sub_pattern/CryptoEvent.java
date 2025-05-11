package com.alan.design.behavioural.pub_sub_pattern;

import com.alan.design.behavioural.observer_pattern.Crypto;
import com.alan.design.behavioural.observer_pattern.CryptoMessage;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CryptoEvent {
    private Crypto topic;
    private CryptoMessage message;

}
