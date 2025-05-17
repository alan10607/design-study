package com.alan.design.behavioural.strategy_pattern;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ticket {
    private TransactionType transactionType;
    private int amount;
}
