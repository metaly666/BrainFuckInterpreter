package com.kondak.symbols;

import com.kondak.environment.Environment;

public class DecrementSymbol implements Symbol{
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
        Environment.Decrement();
    }
}
