package com.alan.design.behavioural.strategy_pattern.strategy;

import com.alan.design.behavioural.strategy_pattern.Ticket;
import com.alan.design.behavioural.strategy_pattern.TransactionType;

public interface TransactionStrategy {
    TransactionType getType();

    String executeTransaction(Ticket ticket);

    String getReceipt(Ticket ticket);
}
