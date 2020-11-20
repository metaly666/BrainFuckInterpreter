package com.kondak.validators;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EmptyValidator implements BrainFuckCodeValidator {
    private static final Logger log = LogManager.getLogger();

    @Override
    public void validate(String code) {
        if (code.isEmpty() || code == null) {
            log.error("Caught empty expression");
            throw new IllegalArgumentException("Expression is empty");
        }
    }
}
