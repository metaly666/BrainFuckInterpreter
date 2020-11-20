package com.kondak.commands;

import com.kondak.implementation.Parser;

import java.util.Deque;

public interface CommandNode {
    void setNode(Deque<Command> node);

    void trigger(Parser parser);
}
