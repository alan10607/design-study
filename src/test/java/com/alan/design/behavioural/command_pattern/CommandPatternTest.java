package com.alan.design.behavioural.command_pattern;

import com.alan.design.behavioural.command_pattern.command.BuyStockCommand;
import com.alan.design.behavioural.command_pattern.command.SellStockCommand;
import com.alan.design.behavioural.command_pattern.command.TradeCommand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CommandPatternTest {
    @Autowired
    private StockService stockService;

    @Test
    void testTradeCommand() {
        TradeCommand buyAPPLCommand = new BuyStockCommand(stockService, "APPL", 10);
        TradeCommand sellTSLACommand = new SellStockCommand(stockService, "TSLA", 5);
        TradeCommandExecutor executor = new TradeCommandExecutor();
        executor.addCommand(buyAPPLCommand);
        executor.addCommand(sellTSLACommand);

        executor.doAction();
        List<String> result = stockService.getHistory();
        assertEquals(result.get(0), "Buy 10 APPL");
        assertEquals(result.get(1), "Sell 5 TSLA");


        executor.undoAction();
        result = stockService.getHistory();
        assertEquals(result.get(0), "Buy 10 APPL");
        assertEquals(result.get(1), "Sell 5 TSLA");
        assertEquals(result.get(2), "Buy 5 TSLA");
        assertEquals(result.get(3), "Sell 10 APPL");

    }
}