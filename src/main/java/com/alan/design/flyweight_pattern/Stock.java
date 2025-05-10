package com.alan.design.flyweight_pattern;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Stock {
    private String symbol;
    private String name;
    private int price;
}