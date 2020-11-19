package com.kondak.implementation;

import com.kondak.symbols.Symbol;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Parser {
    public static List<Symbol> getTaskList(String code, Set<Symbol> symbolsUsed) {
        List<Symbol> taskList = new LinkedList<>();
        for (char symbol : code.toCharArray()) {
            for (Symbol symbolUsed : symbolsUsed) {
                if (symbol == symbolUsed.getImage())
                    taskList.add(symbolUsed);
            }
        }
        return taskList;
    }
}
