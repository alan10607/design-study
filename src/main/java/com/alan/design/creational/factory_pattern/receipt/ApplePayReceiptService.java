package com.alan.design.creational.factory_pattern.receipt;

import org.springframework.stereotype.Service;

@Service
public class ApplePayReceiptService implements ReceiptService {

    @Override
    public String generateReceipt() {
        return "Apple pay receipt";
    }
}