package com.kondak.commands;

import com.kondak.environment.Environment;
import com.kondak.implementation.Parser;

//DESCRIPTION: accept one integer of input, storing its value in the integer at the data pointer.
public class InputCommand implements Command, Component {
    private static final char CHAR = ',';


    @Override
    public char getCharacter() {
        return CHAR;
    }

    @Override
    public void execute() {
        Environment environment = Environment.getInstance();
        environment.input();
    }


    @Override
    public void activate(Parser parser) {

    }
}
