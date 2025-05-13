package com.alan.design.behavioural.command_pattern;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class StockService {
    private final List<String> history = new ArrayList<>();

    public void buyStock(String stock, int quantity) {
        history.add(String.format("Buy %d %s", quantity, stock));
        log.info("Buy {} {}", quantity, stock);
        // skip detail
    }

    public void sellStock(String stock, int quantity) {
        history.add(String.format("Sell %d %s", quantity, stock));
        log.info("Sell {} {}", quantity, stock);
        // skip detail
    }

    public List<String> getHistory() {
        return history;
    }
}
