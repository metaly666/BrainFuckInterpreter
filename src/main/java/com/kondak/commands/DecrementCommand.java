package com.kondak.commands;

import com.kondak.environment.Environment;
import com.kondak.implementation.Parser;

import java.util.Deque;

//DESCRIPTION: decrement (decrease by one) the integer at the data pointer.
public class DecrementCommand implements Command {
    private static final char CHAR = '-';

    @Override
    public char getCharacter() {
        return CHAR;
    }

    @Override
    public void execute() {
        Environment environment = Environment.getInstance();
        environment.decrement();
    }

    @Override
    public void setNode(Deque<Command> node) {

    }

    @Override
    public void trigger(Parser parser) {

    }
}
