package com.kondak.implementation;

import com.kondak.commands.Command;
import com.kondak.commands.Component;

import java.util.Deque;
import java.util.HashSet;
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

        Set<Component> components = new HashSet<>();
        commandsUsed.forEach((component) -> components.add((Component) component));

        //traversal from the end of string for the convenience of saving an array to the node(RightBracketCommand is Composite)
        for (char character : reverseCode.toCharArray()) {
            for (Component component : components) {

                //if the command is in the set->
                if (character == component.getCharacter()) {
                    //->check it for node(Composite) membership->
                    component.activate(this);
                    //->if it is a node(Composite), task list is changed->
                    //->check the taskList
                    taskList = currentNode.peekFirst();
                    assert taskList != null;
                    taskList.push((Command) component);
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
