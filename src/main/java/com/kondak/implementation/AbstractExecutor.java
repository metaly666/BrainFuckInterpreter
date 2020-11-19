package com.kondak.implementation;

import com.kondak.symbols.Symbol;
import com.kondak.validators.BrainFuckCodeValidator;

import java.util.Set;

public abstract class AbstractExecutor implements Executable{
    private Set<BrainFuckCodeValidator> validators;
    protected Set<Symbol> symbolsUsed;

    @Override
    public void setValidators(Set<BrainFuckCodeValidator> validators) {
        this.validators = validators;
    }

    @Override
    public void setSymbolsUsed(Set<Symbol> symbolsUsed) {
        this.symbolsUsed = symbolsUsed;
    }

    public void validateBrainFuckCode(String code) {
        if (validators != null && validators.size() > 0) {
            for (BrainFuckCodeValidator validator : validators) {
                validator.validate(code);
            }
        }
    }
}
