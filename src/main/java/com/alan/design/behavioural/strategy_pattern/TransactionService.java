package com.alan.design.behavioural.strategy_pattern;

import com.alan.design.behavioural.strategy_pattern.strategy.TransactionStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class TransactionService {
    private final Map<TransactionType, TransactionStrategy> strategyMap;

    @Autowired
    public TransactionService(List<TransactionStrategy> strategies) {
        this.strategyMap = strategies.stream()
                .collect(Collectors.toMap(TransactionStrategy::getType, Function.identity()));
    }

    public String executeTransaction(Ticket ticket) {
        return strategyMap.get(ticket.getTransactionType())
                .executeTransaction(ticket);
    }

    public String getReceipt(Ticket ticket) {
        return strategyMap.get(ticket.getTransactionType())
                .getReceipt(ticket);
    }
}
