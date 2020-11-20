package com.kondak.symbols;

public interface Symbol extends SymbolNode {
    char getImage();

    String getDescription();

    void execute();
}
