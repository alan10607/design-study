package com.alan.design.behavioural.strategy_pattern;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class StrategyPatternTest {
    @Autowired
    private TransactionService transactionService;

    @Test
    void testTransactionStrategy() {
        Ticket ticket1 = new Ticket(TransactionType.CASH, 100);
        Ticket ticket2 = new Ticket(TransactionType.CREDIT_CARD, 200);
        Ticket ticket3 = new Ticket(TransactionType.CRYPTO, 300);

        assertEquals(transactionService.executeTransaction(ticket1), "Cash transaction: " + ticket1);
        assertEquals(transactionService.getReceipt(ticket1), "Cash receipt: " + ticket1);
        assertEquals(transactionService.executeTransaction(ticket2), "Credit card transaction: " + ticket2);
        assertEquals(transactionService.getReceipt(ticket2), "Credit card receipt: " + ticket2);
        assertEquals(transactionService.executeTransaction(ticket3), "Crypto transaction: " + ticket3);
        assertEquals(transactionService.getReceipt(ticket3), "Crypto receipt: " + ticket3);
    }
}