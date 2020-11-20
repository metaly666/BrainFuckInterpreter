package com.kondak;

import com.kondak.implementation.Executable;
import com.kondak.implementation.Executor;
import com.kondak.symbols.Symbol;
import com.kondak.symbols.factories.BrainFuckSymbolsFactory;
import com.kondak.symbols.factories.ClassicBrainFuckSymbolsFactory;
import com.kondak.validators.BrainFuckCodeValidator;
import com.kondak.validators.factories.BrainFuckCodeValidatorsFactory;
import com.kondak.validators.factories.CommonBrainFuckCodeValidators;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

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
        BrainFuckCodeValidatorsFactory brainFuckCodeValidatorsFactory = new CommonBrainFuckCodeValidators();
        Set<BrainFuckCodeValidator> brainFuckCodeValidatorSet = brainFuckCodeValidatorsFactory.createValidatorsSet();
        //Symbols
        BrainFuckSymbolsFactory brainFuckSymbolsFactory = new ClassicBrainFuckSymbolsFactory();
        Set<Symbol> symbolSet = brainFuckSymbolsFactory.createSymbolsSet();

        executor = new Executor();
        executor.setValidators(brainFuckCodeValidatorSet);
        executor.setSymbolsUsed(symbolSet);
    }
}
