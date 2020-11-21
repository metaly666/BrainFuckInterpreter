package com.kondak.commands;

import com.kondak.implementation.Parser;

/**
 * The Component interface describes operations that are common to both simple and complex elements of the tree.
 */
public interface Component {
    char getCharacter();

    //name changed from classic execute to activate, so as not to conflict with the interface Command
    void activate(Parser parser);
}
