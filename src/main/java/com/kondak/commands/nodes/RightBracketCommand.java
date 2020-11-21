package com.kondak.commands.nodes;

import com.kondak.commands.Command;
import com.kondak.commands.Component;
import com.kondak.implementation.Parser;

/**
 * DESCRIPTION(Component): leaf informing the parser that
 * the array that follows it(the parser traverses the string in reverse order) must be put into the container
 * <p>
 * DESCRIPTION(Command): if the integer at the data pointer is nonzero,
 * then instead of moving the instruction pointer forward to the next command,
 * jump it back to the command after the matching [ command.
 */
public class RightBracketCommand implements Command, Component {
    private static final char CHAR = ']';

    @Override
    public char getCharacter() {
        return CHAR;
    }

    @Override
    public void execute() {

    }

    @Override
    public void activate(Parser parser) {
        parser.pushNewNode();
    }

}
