package com.kondak.implementation;

import com.kondak.commands.Command;
import com.kondak.validators.BrainFuckCodeValidator;

import java.util.Set;

public interface Executable {
    void executeBrainFuckCode(String code);

    void setCommandsUsed(Set<Command> commandsUsed);

    void setValidators(Set<BrainFuckCodeValidator> validators);
}
