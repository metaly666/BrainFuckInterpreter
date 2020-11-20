package com.kondak.symbols;

import com.kondak.environment.Environment;
import com.kondak.implementation.Parser;

import java.util.Deque;

public class RightShiftSymbol implements Symbol {
    private static final char IMAGE = '>';
    private static final String DESCRIPTION = "increment the data pointer (to point to the next cell to the right).";

    @Override
    public char getImage() {
        return IMAGE;
    }

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

    @Override
    public void execute() {
        Environment environment = Environment.getInstance();
        environment.rightShift();
    }

    @Override
    public void setNode(Deque<Symbol> node) {

    }

    @Override
    public void trigger(Parser parser) {

    }
}
