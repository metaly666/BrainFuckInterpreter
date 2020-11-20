package com.kondak.symbols;

import com.kondak.environment.Environment;
import com.kondak.implementation.Parser;

import java.util.Deque;

public class DecrementSymbol implements Symbol {
    private static final char IMAGE = '-';
    private static final String DESCRIPTION = "decrement (decrease by one) the integer at the data pointer.";

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
        environment.decrement();
    }

    @Override
    public void setNode(Deque<Symbol> node) {

    }

    @Override
    public void trigger(Parser parser) {

    }
}
