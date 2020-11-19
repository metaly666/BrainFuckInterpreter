package com.kondak;

import com.kondak.implementation.Executable;
import com.kondak.implementation.Executor;
import com.kondak.symbols.DecrementSymbol;
import com.kondak.symbols.IncrementSymbol;
import com.kondak.symbols.InputSymbol;
import com.kondak.symbols.LeftShiftSymbol;
import com.kondak.symbols.OutputIntegerSymbol;
import com.kondak.symbols.OutputSymbol;
import com.kondak.symbols.RightShiftSymbol;
import com.kondak.symbols.Symbol;
import com.kondak.validators.BrainFuckCodeValidator;
import com.kondak.validators.EmptyValidator;

import java.util.Arrays;
import java.util.HashSet;

public class Engine {
    private static Executable executor;
    public void start(String code) {
        init();
        executor.executeBrainFuckCode(code);
    }
    private void init() {
        //Validators
        //todo: validators abstract factory
        BrainFuckCodeValidator emptyValidator= new EmptyValidator();

        //Symbols
        //todo: symbols abstract factory
        Symbol incrementSymbol = new IncrementSymbol();
        Symbol decrementSymbol= new DecrementSymbol();
        Symbol rightShiftSymbol = new RightShiftSymbol();
        Symbol leftShiftSymbol = new LeftShiftSymbol();
        Symbol inputSymbol = new InputSymbol();
        Symbol outputSymbol = new OutputSymbol();
        Symbol outputIntegerSymbol = new OutputIntegerSymbol();

        executor = new Executor();
        executor.setValidators(new HashSet(Arrays.asList(new BrainFuckCodeValidator[]{
                emptyValidator
        })));

        executor.setSymbolsUsed(new HashSet(Arrays.asList(new Symbol[]{
                incrementSymbol,
                decrementSymbol,
                rightShiftSymbol,
                leftShiftSymbol,
                inputSymbol,
                outputSymbol,
                outputIntegerSymbol
        })));
    }
}
