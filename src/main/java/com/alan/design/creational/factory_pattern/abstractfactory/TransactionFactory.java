package com.alan.design.creational.factory_pattern.abstractfactory;

import com.alan.design.creational.factory_pattern.payment.PaymentService;
import com.alan.design.creational.factory_pattern.receipt.ReceiptService;

public interface TransactionFactory {
    PaymentService createPaymentService();

    ReceiptService createReceiptService();
}