package com.kondak.implementation;

import com.kondak.commands.Command;
import com.kondak.commands.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * class Parser parses the String of the original brainfuck code and returns the task tree for the Executor class
 */
public class Parser {
    private static final Logger log = LogManager.getLogger();
    private Deque<Deque<Command>> currentNode;

    //Parser composite the tasks as tree
    public Parser() {
        currentNode = new LinkedList<>();
        currentNode.addFirst(new LinkedList<Command>() {
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

                    if (taskList != null) {
                        taskList.push((Command) component);
                    } else {
                        log.error("Task list is null");
                        throw new ArrayIndexOutOfBoundsException("Task list is null");
                    }
                }
            }
        }

        return taskList;
    }

    //if the parser meets a right bracket, a new array is created
    public void pushNewNode() {
        currentNode.push(new LinkedList<>());
    }

    //if the parser meets a left bracket(container), the array is placed in it
    public Deque<Command> popNewNode() {
        return currentNode.pop();
    }
}
