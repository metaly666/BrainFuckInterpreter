package com.kondak.environment;

import java.util.Arrays;
import java.util.Scanner;

public class Environment {
    //In the classic distribution, the array has 30,000 cells, and the pointer begins at the leftmost cell.
    private static final int MAX_SIZE = 30_000;
    private static int cursor = 0;

    private static int[] arr = new int[MAX_SIZE];

    public Environment() {
        Arrays.fill(arr, 0);
    }

    public static void RightShift() {
        Environment.cursor++;
        if (cursor > MAX_SIZE-1)
            throw new Error("stack overflow");
    }
    public static void LeftShift() {
        Environment.cursor--;
        if (cursor < 0)
            throw new Error("request to a non-existent memory location");
    }
    public static void Increment() {
        Environment.arr[cursor]++;
    }
    public static void Decrement() {
        Environment.arr[cursor]--;
    }
    public static void Output() {
        char letter = (char) Environment.arr[cursor];
        System.out.print(letter);
    }
    public static void Input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter integer:");

        while (!sc.hasNextInt()) {
            sc.next();
            System.out.println("Something went wrong...Try entering the integer again\n>>");
        }
        int number = sc.nextInt();
        sc.close();

        Environment.arr[cursor] = number;
    }
    public static void OutputInteger() {
        int integer = Environment.arr[cursor];
        System.out.print(integer);
    }
}
