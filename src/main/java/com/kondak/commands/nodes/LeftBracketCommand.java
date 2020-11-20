package com.kondak.commands.nodes;

import com.kondak.commands.Command;
import com.kondak.commands.Component;
import com.kondak.environment.Environment;
import com.kondak.implementation.Parser;

import java.util.Deque;

//DESCRIPTION: if the integer at the data pointer is zero,
//then instead of moving the instruction pointer forward to the next command,
//jump it forward to the command after the matching ] command.
public class LeftBracketCommand implements Command, Component {
    private static final char CHAR = '[';

    //LeftBracketCommand is Composite
    private Deque<Command> node;

    private void setNode(Deque<Command> node) {
        this.node = node;
    }

    @Override
    public char getCharacter() {
        return CHAR;
    }

    @Override
    public void execute() {
        Environment environment = Environment.getInstance();
        int cursor = environment.getCursor();
        while (environment.getValue(cursor) > 0) {
            node.forEach(Command::execute);
        }
    }

    @Override
    public void activate(Parser parser) {
        setNode(parser.popNewNode());
    }

}
