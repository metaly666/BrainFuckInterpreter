package com.kondak.commands;

import com.kondak.implementation.Parser;

public interface Component {
    char getCharacter();

    void activate(Parser parser);
}
