package com.kondak.validators.factories;

import com.kondak.validators.BrainFuckCodeValidator;

import java.util.Set;

public interface BrainFuckCodeValidatorsFactory {
    Set<BrainFuckCodeValidator> createValidatorsSet();
}
