package com.alan.design.creational.factory_pattern.payment;

import org.springframework.stereotype.Service;

@Service
public class GooglePayPaymentService implements PaymentService {

    @Override
    public String processPayment() {
        return "Google pay payment";
    }
}