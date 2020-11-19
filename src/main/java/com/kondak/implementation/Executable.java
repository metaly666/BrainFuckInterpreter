package com.kondak.implementation;

import com.kondak.symbols.Symbol;
import com.kondak.validators.BrainFuckCodeValidator;

import java.util.Set;

public interface Executable {
    void executeBrainFuckCode(String code);

    void setSymbolsUsed(Set<Symbol> symbolsUsed);

    void setValidators(Set<BrainFuckCodeValidator> validators);
}
