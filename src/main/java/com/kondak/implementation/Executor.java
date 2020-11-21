package com.kondak.implementation;

import com.kondak.commands.Command;
import com.kondak.environment.Environment;
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
        Deque<Command> taskList = parser.getTaskList(code, commandsUsed);
        log.info("Task list received");
        taskList.forEach(Command::execute);
        log.info("Task list done");
        log.info("Getting answer from environment");
        Environment environment = Environment.getInstance();
        String output = environment.getOutputArr();
        log.info("Printing answer...");
        System.out.print(output);
        log.info("Here he is");
    }
}
