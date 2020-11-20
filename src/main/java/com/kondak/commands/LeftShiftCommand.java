package com.kondak.commands;

import com.kondak.environment.Environment;
import com.kondak.implementation.Parser;

import java.util.Deque;

//DESCRIPTION: decrement the data pointer (to point to the next cell to the left).
public class LeftShiftCommand implements Command {
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
    public void setNode(Deque<Command> node) {

    }

    @Override
    public void trigger(Parser parser) {

    }
}
