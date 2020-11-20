package com.kondak.symbols;

import com.kondak.implementation.Parser;

import java.util.Deque;

public interface SymbolNode {
    void setNode(Deque<Symbol> node);

    void trigger(Parser parser);
}
