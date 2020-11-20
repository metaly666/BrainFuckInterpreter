package com.kondak.implementation;

import com.kondak.symbols.Symbol;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Deque;

public class Executor extends AbstractExecutor {
    private static final Logger log = LogManager.getLogger();
    @Override
    public void executeBrainFuckCode(String code) {
        log.info("Checking the code for validity");
        validateBrainFuckCode(code);
        log.info("Code is valid");

        Parser parser = new Parser();
        log.info("Staring parsing the code and composite a list of tasks");
        Deque<Symbol> taskList = parser.getTaskList(code, symbolsUsed);
        log.info("Task list received");
        taskList.forEach(Symbol::execute);
        log.info("Task list done");

    }
}
