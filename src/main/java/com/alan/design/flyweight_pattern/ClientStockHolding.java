package com.alan.design.flyweight_pattern;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientStockHolding {
    private int userId;
    private Stock stock;
    private int buyPrice;
    private int shares;
}