package com.alan.design.creational.factory_pattern.receipt;

import org.springframework.stereotype.Service;

@Service
public class GooglePayReceiptService implements ReceiptService {

    @Override
    public String generateReceipt() {
        return "Google pay receipt";
    }
}