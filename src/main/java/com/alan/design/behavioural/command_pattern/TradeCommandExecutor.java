package com.alan.design.behavioural.command_pattern;

import com.alan.design.behavioural.command_pattern.command.TradeCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class TradeCommandExecutor {
    List<TradeCommand> commands = new ArrayList<>();

    public void addCommand(TradeCommand command) {
        commands.add(command);
    }

    public void doAction() {
        for (TradeCommand command : commands) {
            command.execute();
        }
    }

    public void undoAction() {
        ListIterator<TradeCommand> iterator = commands.listIterator(commands.size()); // Start from last index
        while (iterator.hasPrevious()) {
            TradeCommand command = iterator.previous(); // Get previous
            command.undo();
        }
    }
}
