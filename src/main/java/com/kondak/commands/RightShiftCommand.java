package com.kondak.commands;

import com.kondak.environment.Environment;
import com.kondak.implementation.Parser;

/**
 * DESCRIPTION(Component): the leaf
 * <p>
 * DESCRIPTION(Command): increment the data pointer (to point to the next cell to the right).
 */
public class RightShiftCommand implements Command, Component {
    private static final char CHAR = '>';

    @Override
    public char getCharacter() {
        return CHAR;
    }

    @Override
    public void execute() {
        Environment environment = Environment.getInstance();
        environment.rightShift();
    }

    @Override
    public void activate(Parser parser) {

    }
}
