package com.kondak.validators;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class EmptyValidatorTest {
    private static BrainFuckCodeValidator testInstance;
    private String CODE;

    @BeforeAll
    public static void init() {
        testInstance = new EmptyValidator();
    }

    @DisplayName("throw IllegalArgumentException when CODE == null.")
    @Test
    void testNullCode() {
        CODE = null;
        assertThrows(IllegalArgumentException.class,
                () -> testInstance.validate(CODE),
                "Expression is empty");
    }

    @DisplayName("throw IllegalArgumentException when CODE is empty.")
    @Test
    void testEmptyCode() {
        CODE = "";
        assertThrows(IllegalArgumentException.class,
                () -> testInstance.validate(CODE),
                "Expression is empty");
    }

    @DisplayName("throw IllegalArgumentException when CODE with empty spaces.")
    @Test
    void testEmptySpacesCode() {
        CODE = "        ";
        assertThrows(IllegalArgumentException.class,
                () -> testInstance.validate(CODE),
                "Expression is empty");
    }
}