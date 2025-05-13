package com.alan.design.behavioural.command_pattern.command;

public interface TradeCommand {
    void execute();

    void undo();
}
