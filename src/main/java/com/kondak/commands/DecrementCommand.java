package com.kondak.commands;

import com.kondak.environment.Environment;
import com.kondak.implementation.Parser;

//DESCRIPTION: decrement (decrease by one) the integer at the data pointer.
public class DecrementCommand implements Command, Component {
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
    public void activate(Parser parser) {

    }
}
