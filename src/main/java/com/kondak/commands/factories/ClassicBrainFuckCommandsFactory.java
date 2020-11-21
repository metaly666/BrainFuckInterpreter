package com.kondak.commands.factories;

import com.kondak.commands.Command;
import com.kondak.commands.DecrementCommand;
import com.kondak.commands.IncrementCommand;
import com.kondak.commands.LeftShiftCommand;
import com.kondak.commands.OutputCommand;
import com.kondak.commands.RightShiftCommand;
import com.kondak.commands.nodes.LeftBracketCommand;
import com.kondak.commands.nodes.RightBracketCommand;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ClassicBrainFuckCommandsFactory implements BrainFuckCommandsFactory {
    private final Set<Command> commands;

    public ClassicBrainFuckCommandsFactory() {
        commands = new HashSet<>();
        commands.addAll(Arrays.asList(
                new IncrementCommand(),
                new DecrementCommand(),
                new RightShiftCommand(),
                new LeftShiftCommand(),
                new OutputCommand(),
                new LeftBracketCommand(),
                new RightBracketCommand()
        ));
    }

    @Override
    public Set<Command> createCommandsSet() {
        return commands;
    }
}
