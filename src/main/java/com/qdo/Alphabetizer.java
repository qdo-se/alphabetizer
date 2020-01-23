package com.qdo;

public class Alphabetizer {
    private static final int ALPHA_LENGTH = 26;

    private static final char LOWER_A = 'a';
    private static final char UPPER_A = 'A';

    // mode
    public static final int LOWER_FIRST = 0;
    public static final int UPPER_FIRST = 1;

    public static String transform(String input) {
        return transform(input, LOWER_FIRST);
    }

    public static String transform(String input, int mode) {
        int[] lower = new int[ALPHA_LENGTH];
        int[] upper = new int[ALPHA_LENGTH];

        // Count each letter
        for (char c : input.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                lower[c - LOWER_A]++;
            } else if (c >= 'A' && c <= 'Z') {
                upper[c - UPPER_A]++;
            }
        }

        return mode == UPPER_FIRST
                ? printUpperFirstMode(lower, upper)
                : printLowerFirstMode(lower, upper);
    }

    private static String printLowerFirstMode(int[] lower, int[] upper) {
        StringBuilder output = new StringBuilder();

        // Go from a -> z
        for (int i = 0; i < 26; i++) {
            // Print same letter repeatedly
            for (int j = 0; j < lower[i]; j++) {
                output.append((char) (i + LOWER_A));
            }

            for (int j = 0; j < upper[i]; j++) {
                output.append((char) (i + UPPER_A));
            }
        }

        return output.toString();
    }

    private static String printUpperFirstMode(int[] lower, int[] upper) {
        StringBuilder output = new StringBuilder();

        // Go from a -> z
        for (int i = 0; i < 26; i++) {
            // Print same letter repeatedly
            for (int j = 0; j < upper[i]; j++) {
                output.append((char) (i + UPPER_A));
            }

            for (int j = 0; j < lower[i]; j++) {
                output.append((char) (i + LOWER_A));
            }
        }

        return output.toString();
    }
}
