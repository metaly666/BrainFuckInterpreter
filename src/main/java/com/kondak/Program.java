package com.kondak;

import com.kondak.environment.Environment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Program {
    private static final Engine ENGINE = new Engine();
    private static final Logger log = LogManager.getLogger();

    public static void main(String[] args) {
        /**
         *
         * @param code: ++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.+++++++..+++.>++.<<+++++++++++++++.>.+++.------.--------.>+.>.
         * @return Hello World!
         */
        final String CODE = "++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.+++++++..+++.>++.<<+++++++++++++++.>.+++.------.--------.>+.>.";
        //final String TEST_CODE = "]", "" , "[" , "- (out of bounds)"...;
        //final String CODE = "<";
        log.info("Starting program");
        ENGINE.start(CODE);
        log.info("Program completed successfully");
    }
}
