package com.kondak;

import com.kondak.environment.Environment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

//You should move testing of another classes to the separate test classes(e.g. ExecutorTest)
class ProgramTest {
    private static final Engine engine = new Engine();
    private String CODE;

    @Test()
    void runHelloWorldCode() {
        String expected = "Hello World!";

        CODE = "++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.+++++++..+++.>++.<<+++++++++++++++.>.+++.------.--------.>+.>.";
        engine.start(CODE);

        Environment environment = Environment.getInstance();
        String actual = environment.getOutputArr().trim();

        assertArrayEquals(expected.toCharArray(), actual.toCharArray());
    }

    @Test()
    void runNestedBrackets() {
        Environment environment = Environment.getInstance();
        environment.reset();
        CODE = "+[>[>]<-]";
        engine.start(CODE);
    }

    @DisplayName("throw ArrayIndexOutOfBoundsException when cursor > 30_000.")
    @Test
    void testRightShiftOutOfBounds() {
        Environment environment = Environment.getInstance();
        environment.reset();
        CODE = "+[>]";

        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> engine.start(CODE),
                "Max index is " + (30_000 - 1));
    }
}
