package com.alan.design.creational.factory_pattern.abstractfactory;

import com.alan.design.creational.factory_pattern.payment.ApplePayPaymentService;
import com.alan.design.creational.factory_pattern.payment.PaymentService;
import com.alan.design.creational.factory_pattern.receipt.ApplePayReceiptService;
import com.alan.design.creational.factory_pattern.receipt.ReceiptService;
import org.springframework.stereotype.Service;

@Service
public class ApplePayTransactionFactory implements TransactionFactory {

    @Override
    public PaymentService createPaymentService() {
        return new ApplePayPaymentService();
    }

    @Override
    public ReceiptService createReceiptService() {
        return new ApplePayReceiptService();
    }
}