package com.alan.design.creational.factory_pattern.simplefactory;

import com.alan.design.creational.factory_pattern.payment.ApplePayPaymentService;
import com.alan.design.creational.factory_pattern.payment.GooglePayPaymentService;
import com.alan.design.creational.factory_pattern.payment.PaymentService;
import com.alan.design.creational.factory_pattern.receipt.ApplePayReceiptService;
import com.alan.design.creational.factory_pattern.receipt.GooglePayReceiptService;
import com.alan.design.creational.factory_pattern.receipt.ReceiptService;
import org.springframework.stereotype.Service;

@Service
public class TransactionSimpleFactory {

    public PaymentService createPaymentService(PaymentProvider provider) {
        switch (provider) {
            case GOOGLE_PAY:
                return new GooglePayPaymentService();
            case APPLE_PAY:
                return new ApplePayPaymentService();
            default:
                throw new IllegalStateException("Unknown payment provider");
        }
    }

    public ReceiptService createReceiptService(PaymentProvider provider) {
        switch (provider) {
            case GOOGLE_PAY:
                return new GooglePayReceiptService();
            case APPLE_PAY:
                return new ApplePayReceiptService();
            default:
                throw new IllegalStateException("Unknown payment provider");
        }
    }

}
