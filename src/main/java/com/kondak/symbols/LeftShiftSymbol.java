package com.kondak.symbols;

import com.kondak.environment.Environment;

public class LeftShiftSymbol implements Symbol{
    private static final char IMAGE = '<';
    private static final String DESCRIPTION = "decrement the data pointer (to point to the next cell to the left).";

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
        Environment.LeftShift();
    }
}
