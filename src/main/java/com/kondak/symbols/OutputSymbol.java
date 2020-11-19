package com.kondak.symbols;

import com.kondak.environment.Environment;

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
        Environment.Output();
    }
}
