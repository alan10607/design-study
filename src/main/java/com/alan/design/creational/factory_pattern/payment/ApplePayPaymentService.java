package com.alan.design.creational.factory_pattern.payment;

import org.springframework.stereotype.Service;

@Service
public class ApplePayPaymentService implements PaymentService {

    @Override
    public String processPayment() {
        return "Apple pay payment";
    }
}