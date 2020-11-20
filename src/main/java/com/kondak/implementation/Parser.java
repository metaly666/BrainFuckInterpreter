package com.kondak.implementation;

import com.kondak.symbols.Symbol;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Set;

public class Parser {
    private Deque<Deque<Symbol>> currentNode;

    //Parser composite the tasks as tree
    public Parser() {
        currentNode = new LinkedList<>();
        currentNode.addFirst(new LinkedList<>() {
        });
    }

    public Deque<Symbol> getTaskList(String code, Set<Symbol> symbolsUsed) {
        String reverseCode = new StringBuffer(code).reverse().toString();
        Deque<Symbol> taskList = currentNode.peekFirst();

        //traversal from the end of string for the convenience of saving an array to the node(RightBracketSymbol)
        for (char symbol : reverseCode.toCharArray()) {
            for (Symbol symbolUsed : symbolsUsed) {

                //if the symbol is in the set->
                if (symbol == symbolUsed.getImage()) {
                    //->check it for node membership->
                    symbolUsed.trigger(this);
                    //-> if it is a node, task list is changed->
                    //->check the taskList
                    taskList = currentNode.peekFirst();
                    taskList.push(symbolUsed);
                }
            }
        }

        return taskList;
    }

    public void pushNewNode() {
        currentNode.push(new LinkedList<Symbol>());
    }

    public Deque<Symbol> popNewNode() {
        return currentNode.pop();
    }
}
