package com.kondak.commands.factories;

import com.kondak.commands.Command;

import java.util.Set;

public interface BrainFuckCommandsFactory {
    Set<Command> createCommandsSet();
}
