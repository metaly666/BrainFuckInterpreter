package com.kondak.symbols;

public class RightBracketSymbol implements Symbol {
    private static final char IMAGE = ']';
    private static final String DESCRIPTION = "if the integer at the data pointer is nonzero, then instead of moving the instruction pointer forward to the next command, jump it back to the command after the matching [ command.";

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

    }
}
