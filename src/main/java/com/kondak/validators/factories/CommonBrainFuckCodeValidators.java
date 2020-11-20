package com.kondak.validators.factories;

import com.kondak.validators.BrainFuckCodeValidator;
import com.kondak.validators.EmptyValidator;
import com.kondak.validators.LandauRuleValidator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CommonBrainFuckCodeValidators implements BrainFuckCodeValidatorsFactory {
    private final Set<BrainFuckCodeValidator> validatorsSet;

    public CommonBrainFuckCodeValidators() {
        validatorsSet = new HashSet<>();
        validatorsSet.addAll(Arrays.asList(
                new EmptyValidator(),
                new LandauRuleValidator()
        ));
    }

    @Override
    public Set<BrainFuckCodeValidator> createValidatorsSet() {
        return validatorsSet;
    }
}
