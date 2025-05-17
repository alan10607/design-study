package com.alan.design.behavioural.strategy_pattern.strategy;

import com.alan.design.behavioural.strategy_pattern.Ticket;
import com.alan.design.behavioural.strategy_pattern.TransactionType;
import org.springframework.stereotype.Service;

@Service
public class CreditCardTransactionService implements TransactionStrategy {

    @Override
    public TransactionType getType() {
        return TransactionType.CREDIT_CARD;
    }

    @Override
    public String executeTransaction(Ticket ticket) {
        return "Credit card transaction: " + ticket;
    }

    @Override
    public String getReceipt(Ticket ticket) {
        return "Credit card receipt: " + ticket;
    }
}
