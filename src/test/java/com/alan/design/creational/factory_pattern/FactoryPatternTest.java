package com.alan.design.creational.factory_pattern;

import com.alan.design.creational.factory_pattern.abstractfactory.ApplePayTransactionFactory;
import com.alan.design.creational.factory_pattern.abstractfactory.GooglePayTransactionFactory;
import com.alan.design.creational.factory_pattern.payment.ApplePayPaymentService;
import com.alan.design.creational.factory_pattern.payment.GooglePayPaymentService;
import com.alan.design.creational.factory_pattern.payment.PaymentService;
import com.alan.design.creational.factory_pattern.receipt.ApplePayReceiptService;
import com.alan.design.creational.factory_pattern.receipt.GooglePayReceiptService;
import com.alan.design.creational.factory_pattern.receipt.ReceiptService;
import com.alan.design.creational.factory_pattern.simplefactory.PaymentProvider;
import com.alan.design.creational.factory_pattern.simplefactory.TransactionSimpleFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class FactoryPatternTest {
    @Autowired
    private TransactionSimpleFactory transactionSimpleFactory;

    @Autowired
    private GooglePayTransactionFactory googlePayTransactionFactory;

    @Autowired
    private ApplePayTransactionFactory applePayTransactionFactory;


    @Test
    void testSimpleFactory() {
        PaymentService googlePayPaymentService = transactionSimpleFactory.createPaymentService(PaymentProvider.GOOGLE_PAY);
        ReceiptService googlePayReceiptService = transactionSimpleFactory.createReceiptService(PaymentProvider.GOOGLE_PAY);

        PaymentService applePayPaymentService = transactionSimpleFactory.createPaymentService(PaymentProvider.APPLE_PAY);
        ReceiptService applePayReceiptService = transactionSimpleFactory.createReceiptService(PaymentProvider.APPLE_PAY);

        assertTrue(googlePayPaymentService instanceof GooglePayPaymentService);
        assertEquals(googlePayPaymentService.processPayment(), "Google pay payment");
        assertTrue(googlePayReceiptService instanceof GooglePayReceiptService);
        assertEquals(googlePayReceiptService.generateReceipt(), "Google pay receipt");

        assertTrue(applePayPaymentService instanceof ApplePayPaymentService);
        assertEquals(applePayPaymentService.processPayment(), "Apple pay payment");
        assertTrue(applePayReceiptService instanceof ApplePayReceiptService);
        assertEquals(applePayReceiptService.generateReceipt(), "Apple pay receipt");
    }

    @Test
    void testAbstractFactory() {
        PaymentService googlePayPaymentService = googlePayTransactionFactory.createPaymentService();
        ReceiptService googlePayReceiptService = googlePayTransactionFactory.createReceiptService();

        PaymentService applePayPaymentService = applePayTransactionFactory.createPaymentService();
        ReceiptService applePayReceiptService = applePayTransactionFactory.createReceiptService();

        assertTrue(googlePayPaymentService instanceof GooglePayPaymentService);
        assertEquals(googlePayPaymentService.processPayment(), "Google pay payment");
        assertTrue(googlePayReceiptService instanceof GooglePayReceiptService);
        assertEquals(googlePayReceiptService.generateReceipt(), "Google pay receipt");

        assertTrue(applePayPaymentService instanceof ApplePayPaymentService);
        assertEquals(applePayPaymentService.processPayment(), "Apple pay payment");
        assertTrue(applePayReceiptService instanceof ApplePayReceiptService);
        assertEquals(applePayReceiptService.generateReceipt(), "Apple pay receipt");
    }

}