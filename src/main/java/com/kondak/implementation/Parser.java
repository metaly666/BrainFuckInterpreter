package com.kondak.implementation;

import com.kondak.commands.Command;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Set;

public class Parser {
    private Deque<Deque<Command>> currentNode;

    //Parser composite the tasks as tree
    public Parser() {
        currentNode = new LinkedList<>();
        currentNode.addFirst(new LinkedList<>() {
        });
    }

    public Deque<Command> getTaskList(String code, Set<Command> commandsUsed) {
        String reverseCode = new StringBuffer(code).reverse().toString();
        Deque<Command> taskList = currentNode.peekFirst();

        //traversal from the end of string for the convenience of saving an array to the node(RightBracketCommand)
        for (char command : reverseCode.toCharArray()) {
            for (Command commandUsed : commandsUsed) {

                //if the command is in the set->
                if (command == commandUsed.getCharacter()) {
                    //->check it for node membership->
                    commandUsed.trigger(this);
                    //->if it is a node, task list is changed->
                    //->check the taskList
                    taskList = currentNode.peekFirst();
                    assert taskList != null;
                    taskList.push(commandUsed);
                }
            }
        }

        return taskList;
    }

    public void pushNewNode() {
        currentNode.push(new LinkedList<>());
    }

    public Deque<Command> popNewNode() {
        return currentNode.pop();
    }
}
