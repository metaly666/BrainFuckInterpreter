package com.kondak.commands;

import com.kondak.environment.Environment;
import com.kondak.implementation.Parser;

/**
 * DESCRIPTION(Component): the leaf
 * <p>
 * DESCRIPTION(Command): increment (increase by one) the integer at the data pointer.
 */
public class IncrementCommand implements Command, Component {
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
    public void activate(Parser parser) {

    }
}
