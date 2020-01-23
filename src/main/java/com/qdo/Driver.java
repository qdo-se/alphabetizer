package com.qdo;

import java.util.Scanner;

public class Driver {
    private static Scanner input = new Scanner(System.in);
    private static boolean run = true;
    private static int mode = Alphabetizer.LOWER_FIRST;

    public static void main(String[] args) {
        while (run) {
            prompt();
        }
    }

    private static void prompt() {
        System.out.print("Please enter a string: ");

        String userInput = input.nextLine();

        if (userInput.equalsIgnoreCase("\\q")) {
            quit();
        } else if (userInput.equalsIgnoreCase("\\u")) {
            switchUpperMode();
        } else if (userInput.equalsIgnoreCase("\\l")) {
            switchLowerMode();
        } else if (userInput.equalsIgnoreCase("\\h")) {
            printUsage();
        } else {
            printNewString(userInput, mode);
        }
    }

    private static void quit() {
        run = false;
        System.out.println("Bye!");
    }

    private static void switchUpperMode() {
        mode = Alphabetizer.UPPER_FIRST;
        System.out.println("Switch to Upper First Mode.\n");
    }

    private static void switchLowerMode() {
        mode = Alphabetizer.LOWER_FIRST;
        System.out.println("Switch to Lower First Mode.\n");
    }

    private static void printNewString(String userInput, int mode) {
        try {
            System.out.println("New string: " + Alphabetizer.transform(userInput, mode) + "\n");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + "\nPlease try again!");
        }
    }

    private static void printUsage() {
        System.out.println("Current mode: " +
                (mode == Alphabetizer.UPPER_FIRST
                        ? "upper-case character first"
                        : "lower-case character first")
        );

        System.out.println("Usage:\n" +
                "\t\\q: quit\n" +
                "\t\\h: usage\n" +
                "\t\\u: upper-case character first\n" +
                "\t\\l: lower-case character first\n");
    }
}
