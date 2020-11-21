package com.kondak.commands;

import com.kondak.environment.Environment;
import com.kondak.implementation.Parser;

/**
 * DESCRIPTION(Component): the leaf
 * <p>
 * DESCRIPTION(Command): decrement the data pointer (to point to the next cell to the left).
 */
public class LeftShiftCommand implements Command, Component {
    private static final char CHAR = '<';

    @Override
    public char getCharacter() {
        return CHAR;
    }

    @Override
    public void execute() {
        Environment environment = Environment.getInstance();
        environment.leftShift();
    }

    @Override
    public void activate(Parser parser) {

    }
}
