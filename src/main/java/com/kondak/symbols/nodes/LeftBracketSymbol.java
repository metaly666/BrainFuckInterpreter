package com.kondak.symbols.nodes;

import com.kondak.environment.Environment;
import com.kondak.implementation.Parser;
import com.kondak.symbols.Symbol;
import com.kondak.symbols.SymbolNode;

import java.util.Deque;

public class LeftBracketSymbol implements Symbol, SymbolNode {
    private static final char IMAGE = '[';
    private static final String DESCRIPTION = "if the integer at the data pointer is zero, then instead of moving the instruction pointer forward to the next command, jump it forward to the command after the matching ] command.";

    private Deque<Symbol> node;
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
        int cursor = environment.getCursor();
        while (environment.getValue(cursor) > 0) {
            node.forEach(Symbol::execute);
        }
    }

    @Override
    public void setNode(Deque<Symbol> node) {
        this.node = node;
    }

    @Override
    public void trigger(Parser parser) {
        setNode(parser.popNewNode());
    }


}
