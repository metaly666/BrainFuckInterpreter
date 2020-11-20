package com.kondak.symbols;

import com.kondak.environment.Environment;
import com.kondak.implementation.Parser;

import java.util.Deque;

public class OutputSymbol implements Symbol{
    private static final char IMAGE = '.';
    private static final String DESCRIPTION = "output the char at the data pointer.";

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
        environment.output();
    }

    @Override
    public void setNode(Deque<Symbol> node) {

    }

    @Override
    public void trigger(Parser parser) {

    }
}
