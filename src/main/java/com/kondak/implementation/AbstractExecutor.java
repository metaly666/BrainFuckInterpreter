package com.kondak.implementation;

import com.kondak.commands.Command;
import com.kondak.validators.BrainFuckCodeValidator;

import java.util.Set;

public abstract class AbstractExecutor implements Executable {
    private Set<BrainFuckCodeValidator> validators;
    protected Set<Command> commandsUsed;

    @Override
    public void setValidators(Set<BrainFuckCodeValidator> validators) {
        this.validators = validators;
    }

    @Override
    public void setCommandsUsed(Set<Command> commandsUsed) {
        this.commandsUsed = commandsUsed;
    }

    public void validateBrainFuckCode(String code) {
        if (validators != null && validators.size() > 0) {
            for (BrainFuckCodeValidator validator : validators) {
                validator.validate(code);
            }
        }
    }
}
