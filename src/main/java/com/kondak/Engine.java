package com.kondak;

import com.kondak.commands.Command;
import com.kondak.commands.factories.BrainFuckCommandsFactory;
import com.kondak.commands.factories.ClassicBrainFuckCommandsFactory;
import com.kondak.implementation.Executable;
import com.kondak.implementation.Executor;
import com.kondak.validators.BrainFuckCodeValidator;
import com.kondak.validators.factories.BrainFuckCodeValidatorsFactory;
import com.kondak.validators.factories.CommonBrainFuckCodeValidatorsFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

/**
 * class Engine is initializer that launches the Executor
 */
public class Engine {
    private static final Logger log = LogManager.getLogger();
    private static Executable executor;

    public void start(String code) {
        log.info("Initialising...");
        init();
        log.info("Initialise done! Start executing code");
        executor.executeBrainFuckCode(code);
        log.info("Code executed");
    }

    private void init() {
        //Validators
        BrainFuckCodeValidatorsFactory brainFuckCodeValidatorsFactory = new CommonBrainFuckCodeValidatorsFactory();
        Set<BrainFuckCodeValidator> brainFuckCodeValidatorSet = brainFuckCodeValidatorsFactory.createValidatorsSet();
        //Commands
        BrainFuckCommandsFactory brainFuckCommandsFactory = new ClassicBrainFuckCommandsFactory();
        Set<Command> commandSet = brainFuckCommandsFactory.createCommandsSet();

        executor = new Executor();
        executor.setValidators(brainFuckCodeValidatorSet);
        executor.setCommandsUsed(commandSet);
    }
}
