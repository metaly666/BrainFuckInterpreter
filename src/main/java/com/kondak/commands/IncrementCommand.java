package com.kondak.commands;

import com.kondak.environment.Environment;
import com.kondak.implementation.Parser;

import java.util.Deque;

//DESCRIPTION: increment (increase by one) the integer at the data pointer.
public class IncrementCommand implements Command {
    private static final char CHAR = '+';

    @Override
    public char getCharacter() {
        return CHAR;
    }

    @Override
    public void execute() {
        Environment environment = Environment.getInstance();
        environment.increment();
    }

    @Override
    public void setNode(Deque<Command> node) {

    }

    @Override
    public void trigger(Parser parser) {

    }
}
