package com.alan.design.creational.factory_pattern.abstractfactory;

import com.alan.design.creational.factory_pattern.payment.GooglePayPaymentService;
import com.alan.design.creational.factory_pattern.payment.PaymentService;
import com.alan.design.creational.factory_pattern.receipt.GooglePayReceiptService;
import com.alan.design.creational.factory_pattern.receipt.ReceiptService;
import org.springframework.stereotype.Service;

@Service
public class GooglePayTransactionFactory implements TransactionFactory {

    @Override
    public PaymentService createPaymentService() {
        return new GooglePayPaymentService();
    }

    @Override
    public ReceiptService createReceiptService() {
        return new GooglePayReceiptService();
    }
}