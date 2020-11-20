package com.kondak.commands;

public interface Command extends CommandNode {
    char getCharacter();

    void execute();
}
