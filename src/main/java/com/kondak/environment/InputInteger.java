package com.kondak.environment;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class InputInteger {
    private static final Logger log = LogManager.getLogger();
    public int getIntFromUser() {
        Scanner sc = new Scanner(System.in);
        log.info("Scanner opened");
        System.out.print("Enter integer:\n>");

        while (!sc.hasNextInt()) {
            sc.next();
            log.info("Incorrect data entered");
            System.out.println("Something went wrong...Try entering the integer again\n>>");
        }
        int number = sc.nextInt();
        sc.close();
        log.info("Scanner closed");
        return number;
    }
}
