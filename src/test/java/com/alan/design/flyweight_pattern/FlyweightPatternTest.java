package com.alan.design.flyweight_pattern;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@SpringBootTest
class FlyweightPatternTest {
    @Autowired
    private StockFactory stockFactory;

    @BeforeEach
    void setUp() {
        stockFactory = new StockFactory();
        stockFactory.addStock("2330", "TSMC", 900);
        stockFactory.addStock("2454", "MTK", 1300);
    }

    @Test
    void createClientStockHolding() {
        Stock stock1 = stockFactory.getStock("2330");
        Stock stock2 = stockFactory.getStock("2454");
        Stock stock1Again = stockFactory.getStock("2330");

        ClientStockHolding client1Holding1 = new ClientStockHolding(1, stock1, 800, 2);
        ClientStockHolding client1Holding2 = new ClientStockHolding(1, stock2, 1000, 1);
        ClientStockHolding client2Holding1 = new ClientStockHolding(2, stock1Again, 700, 3);


        assertSame(stock1, stock1Again); // should be the same flyweight object

        assertEquals(1, client1Holding1.getUserId());
        assertEquals(stock1, client1Holding1.getStock());
        assertEquals(800, client1Holding1.getBuyPrice());
        assertEquals(2, client1Holding1.getShares());

        assertEquals(1, client1Holding2.getUserId());
        assertEquals(stock2, client1Holding2.getStock());
        assertEquals(1000, client1Holding2.getBuyPrice());
        assertEquals(1, client1Holding2.getShares());

        assertEquals(2, client2Holding1.getUserId());
        assertEquals(stock1, client2Holding1.getStock());
        assertEquals(700, client2Holding1.getBuyPrice());
        assertEquals(3, client2Holding1.getShares());
    }
}