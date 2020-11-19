package com.kondak.implementation;

import com.kondak.symbols.Symbol;

import java.util.List;

public class Executor extends AbstractExecutor{
    @Override
    public void executeBrainFuckCode(String code) {
        validateBrainFuckCode(code);

        List<Symbol> taskList = Parser.getTaskList(code, symbolsUsed);

        taskList.forEach(Symbol::execute);

    }
}
