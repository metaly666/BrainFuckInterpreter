package com.kondak.symbols.factories;

import com.kondak.symbols.*;
import com.kondak.symbols.nodes.LeftBracketSymbol;
import com.kondak.symbols.nodes.RightBracketSymbol;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ClassicBrainFuckSymbolsFactory implements BrainFuckSymbolsFactory {
    private static Set<Symbol> symbolsSet;

    public ClassicBrainFuckSymbolsFactory() {
        symbolsSet = new HashSet<>();
        symbolsSet.addAll(Arrays.asList(
                new IncrementSymbol(),
                new DecrementSymbol(),
                new RightShiftSymbol(),
                new LeftShiftSymbol(),
                new InputSymbol(),
                new OutputSymbol(),
                new LeftBracketSymbol(),
                new RightBracketSymbol()
        ));
    }

    @Override
    public Set<Symbol> createSymbolsSet() {
        return symbolsSet;
    }
}
