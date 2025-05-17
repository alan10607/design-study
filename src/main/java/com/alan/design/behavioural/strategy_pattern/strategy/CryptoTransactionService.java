package com.alan.design.behavioural.strategy_pattern.strategy;

import com.alan.design.behavioural.strategy_pattern.Ticket;
import com.alan.design.behavioural.strategy_pattern.TransactionType;
import org.springframework.stereotype.Service;

@Service
public class CryptoTransactionService implements TransactionStrategy {

    @Override
    public TransactionType getType() {
        return TransactionType.CRYPTO;
    }

    @Override
    public String executeTransaction(Ticket ticket) {
        return "Crypto transaction: " + ticket;
    }

    @Override
    public String getReceipt(Ticket ticket) {
        return "Crypto receipt: " + ticket;
    }
}
