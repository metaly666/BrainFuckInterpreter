package com.kondak.validators;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

//You should add test for positive flow either
class LandauRuleValidatorTest {
    private static BrainFuckCodeValidator testInstance;
    private String CODE;

    @BeforeAll
    public static void init() {
        testInstance = new LandauRuleValidator();
    }

    @DisplayName("throw IllegalArgumentException when CODE has an odd number of brackets.")
    @Test
    void testAbsenceOfRightBracket() {
        CODE = "[";
        assertThrows(IllegalArgumentException.class,
                () -> testInstance.validate(CODE),
                "In expression syntax error: missing character ]");
    }

    @DisplayName("throw IllegalArgumentException when CODE has an odd number of brackets.")
    @Test
    void testAbsenceOfLeftBracket() {
        CODE = "]";
        assertThrows(IllegalArgumentException.class,
                () -> testInstance.validate(CODE),
                "In expression syntax error: missing character [");
    }
}
