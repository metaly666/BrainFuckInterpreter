package com.kondak.environment;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

//Singleton
public class Environment {
    private static final Logger log = LogManager.getLogger();
    //In the classic distribution, the array has 30,000 cells, and the pointer begins at the leftmost cell.
    private static final int MAX_SIZE = 30_000;
    //Max Integer
    private static final int MAX_VALUE = 2_147_483_647;
    private static final int MIN_VALUE = 0;
    private int cursor = 0;

    private final int[] arr;

    private static Environment instance;

    public static Environment getInstance() {
        if (instance == null) {
            instance = new Environment();
            log.info("Work environment initialized");
        }
        return instance;
    }

    private Environment() {
        arr = new int[MAX_SIZE];
        Arrays.fill(arr, 0);
    }

    public void rightShift() {
        this.cursor++;
        if (this.cursor > MAX_SIZE - 1) {
            log.error("Out of bounds");
            throw new ArrayIndexOutOfBoundsException("Max index is " + (MAX_SIZE - 1));
        }
    }

    public void leftShift() {
        this.cursor--;
        if (this.cursor < 0) {
            log.error("Out of bounds");
            throw new ArrayIndexOutOfBoundsException("index cannot be less than 0");
        }
    }

    public void increment() {
        if (this.arr[cursor] < MAX_VALUE) {
            this.arr[cursor]++;
        } else {
            log.error("Out of bounds");
            throw new ArrayIndexOutOfBoundsException("Value cannot be biggest than " + MAX_VALUE);
        }
    }

    public void decrement() {
        if (this.arr[cursor] > MIN_VALUE) {
            this.arr[cursor]--;
        } else {
            log.error("Out of bounds");
            throw new ArrayIndexOutOfBoundsException("Value cannot be less than " + MIN_VALUE);
        }
    }

    public void output() {
        char letter = (char) this.arr[this.cursor];
        System.out.print(letter);
    }

    public void input() {
        InputInteger inputInteger = new InputInteger();
        int number = inputInteger.getIntFromUser();

        this.arr[this.cursor] = number;
    }

    public void outputInteger() {
        int integer = this.arr[this.cursor];
        System.out.print(integer + " ");
    }

    public int getValue(int cursor) {
        return this.arr[cursor];
    }

    public int getCursor() {
        return this.cursor;
    }
}
