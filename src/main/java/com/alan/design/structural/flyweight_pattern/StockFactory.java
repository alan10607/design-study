package com.alan.design.structural.flyweight_pattern;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StockFactory {
    private final Map<String, Stock> stockMap = new HashMap<>();

    public Stock getStock(String symbol) {
        return stockMap.get(symbol);
    }

    public void addStock(String symbol, String name, int price) {
        stockMap.put(symbol, new Stock(symbol, name, price));
    }
}