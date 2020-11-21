package com.kondak.implementation;

import com.kondak.commands.Command;
import com.kondak.commands.Component;
import com.kondak.commands.IncrementCommand;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ParserTest {

    @Test
    void getTaskListTestIncrementCommand() {
        Parser parser = new Parser();
        Component incrementCommand = mock(IncrementCommand.class);
        when(incrementCommand.getCharacter()).thenReturn('+');
        Set<Command> commandSet = new HashSet<>();
        commandSet.add((Command) incrementCommand);
        String CODE = "+";

        assertArrayEquals(commandSet.toArray(), parser.getTaskList(CODE, commandSet).toArray());
    }

    @Test
    void getTaskListTestDecrementCommand() {
        Parser parser = new Parser();
        Component incrementCommand = mock(IncrementCommand.class);
        when(incrementCommand.getCharacter()).thenReturn('-');
        Set<Command> commandSet = new HashSet<>();
        commandSet.add((Command) incrementCommand);
        String CODE = "-";

        assertArrayEquals(commandSet.toArray(), parser.getTaskList(CODE, commandSet).toArray());
    }

    @Test
    void getTaskListTestLeftShiftCommand() {
        Parser parser = new Parser();
        Component incrementCommand = mock(IncrementCommand.class);
        when(incrementCommand.getCharacter()).thenReturn('<');
        Set<Command> commandSet = new HashSet<>();
        commandSet.add((Command) incrementCommand);
        String CODE = "<";

        assertArrayEquals(commandSet.toArray(), parser.getTaskList(CODE, commandSet).toArray());
    }

    @Test
    void getTaskListTestRightShiftCommand() {
        Parser parser = new Parser();
        Component incrementCommand = mock(IncrementCommand.class);
        when(incrementCommand.getCharacter()).thenReturn('>');
        Set<Command> commandSet = new HashSet<>();
        commandSet.add((Command) incrementCommand);
        String CODE = ">";

        assertArrayEquals(commandSet.toArray(), parser.getTaskList(CODE, commandSet).toArray());
    }
}