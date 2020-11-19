package com.kondak.validators;

public class EmptyValidator implements BrainFuckCodeValidator {
    @Override
    public void validate(String code) {
        if (code == "" || code == null || code.isEmpty())
            throw new IllegalArgumentException("Expression is empty");
    }
}
