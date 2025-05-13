package com.alan.design.behavioural.command_pattern.command;

import com.alan.design.behavioural.command_pattern.StockService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SellStockCommand implements TradeCommand {
    private final StockService stockService;
    private final String stock;
    private final int quantity;

    @Override
    public void execute() {
        stockService.sellStock(stock, quantity);
    }

    @Override
    public void undo() {
        stockService.buyStock(stock, quantity);
    }

}
