package com.kondak.implementation;

import com.kondak.commands.Command;
import com.kondak.commands.Component;
import com.kondak.commands.IncrementCommand;
import com.kondak.commands.nodes.LeftBracketCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//where are tests for public methods pushNewNode() and popNewNode()?
class ParserTest {

    @Test
    void getTaskListTestIncrementCommand() {
        //You can have the only parser obj and mocked Component obj in all methods
        Parser parser = new Parser();
        Component incrementCommand = mock(IncrementCommand.class);
        when(incrementCommand.getCharacter()).thenReturn('+');
        Set<Command> commandSet = new HashSet<>();
        commandSet.add((Command) incrementCommand);
        //redundant var
        String CODE = "+";

        //It is not necessary to check all CODES(+,-,> etc) as in all cases java code is the same. You must cover all branches of the java code instead
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

    @DisplayName("throw ArrayIndexOutOfBoundsException when tasks count < 0.")
    @Test
    void testEmpyTaskList() {
        Parser parser = new Parser();
        String CODE = "[[";

        Command command = new LeftBracketCommand();
        Set<Command> commandSet = new HashSet<>();
        commandSet.add(command);

        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> parser.getTaskList(CODE, commandSet),
                "Task list is null");
    }
}
