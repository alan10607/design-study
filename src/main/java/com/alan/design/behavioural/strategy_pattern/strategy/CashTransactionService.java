package com.alan.design.behavioural.strategy_pattern.strategy;

import com.alan.design.behavioural.strategy_pattern.Ticket;
import com.alan.design.behavioural.strategy_pattern.TransactionType;
import org.springframework.stereotype.Service;

@Service
public class CashTransactionService implements TransactionStrategy {

    @Override
    public TransactionType getType() {
        return TransactionType.CASH;
    }

    @Override
    public String executeTransaction(Ticket ticket) {
        return "Cash transaction: " + ticket;
    }

    @Override
    public String getReceipt(Ticket ticket) {
        return "Cash receipt: " + ticket;
    }
}
