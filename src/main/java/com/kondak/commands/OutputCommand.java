package com.kondak.commands;

import com.kondak.environment.Environment;
import com.kondak.implementation.Parser;

//DESCRIPTION: output the char at the data pointer.
public class OutputCommand implements Command, Component {
    private static final char CHAR = '.';

    @Override
    public char getCharacter() {
        return CHAR;
    }

    @Override
    public void execute() {
        Environment environment = Environment.getInstance();
        environment.output();
    }

    @Override
    public void activate(Parser parser) {

    }
}
