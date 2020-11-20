package com.kondak.commands;

import com.kondak.environment.Environment;
import com.kondak.implementation.Parser;

import java.util.Deque;

//DESCRIPTION: increment the data pointer (to point to the next cell to the right).
public class RightShiftCommand implements Command {
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
    public void setNode(Deque<Command> node) {

    }

    @Override
    public void trigger(Parser parser) {

    }
}
