package com.qdo;

import java.util.Scanner;

public class CommandPrompt {
    // @TODO dependency injection
    private Scanner input = new Scanner(System.in);
    private boolean run = true;
    private int mode = Alphabetizer.LOWER_FIRST;

    public Scanner getInput() {
        return input;
    }

    public boolean isRun() {
        return run;
    }

    public void setRun(boolean run) {
        this.run = run;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public void run() {
        while (isRun()) {
            prompt();
        }
    }

    private void prompt() {
        System.out.print("Please enter a string: ");

        String userInput = getInput().nextLine();

        if (userInput.equalsIgnoreCase("\\q")) {
            quit();
        } else if (userInput.equalsIgnoreCase("\\u")) {
            switchUpperMode();
        } else if (userInput.equalsIgnoreCase("\\l")) {
            switchLowerMode();
        } else if (userInput.equalsIgnoreCase("\\h")) {
            printUsage();
        } else {
            printNewString(userInput, getMode());
        }
    }

    private void quit() {
        setRun(false);
        System.out.println("Bye!");
    }

    private void switchUpperMode() {
        setMode(Alphabetizer.UPPER_FIRST);
        System.out.println("Switch to Upper First Mode.\n");
    }

    private void switchLowerMode() {
        setMode(Alphabetizer.LOWER_FIRST);
        System.out.println("Switch to Lower First Mode.\n");
    }

    private void printNewString(String userInput, int mode) {
        try {
            System.out.println("New string: " + Alphabetizer.transform(userInput, mode) + "\n");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + "\nPlease try again!");
        }
    }

    private void printUsage() {
        System.out.println("Current mode: " +
                (getMode() == Alphabetizer.UPPER_FIRST
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
