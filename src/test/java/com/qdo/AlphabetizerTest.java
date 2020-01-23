package com.qdo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlphabetizerTest {
    private void testHelper(String input, String expected) {
        assertEquals(expected, Alphabetizer.transform(input));
    }

    private void testHelper(String input, String expected, int mode) {
        assertEquals(expected, Alphabetizer.transform(input, mode));
    }

    @Test
    public void testSingleLowerLetter() {
        testHelper("a", "a");
    }

    @Test
    public void testSingleUpperLetter() {
        testHelper("Z", "Z");
    }

    @Test
    public void testEmpty() {
        testHelper("", "");
    }

    @Test
    public void testSpace() {
        testHelper("      ", "");
    }

    @Test
    public void testNumber() {
        testHelper("0123456789", "");
    }

    @Test
    public void testSpecialCharacters() {
        testHelper("!@#$%^&*()-_=+[{}]\\|;:',<.>/?`~", "");
    }

    @Test
    public void testTwoLetter() {
        testHelper("Ba", "aB");
    }

    @Test
    public void testSameLetterDifferentCasesLowerFirstMode() {
        testHelper("bAcaB", "aAbBc");
    }

    @Test
    public void testSameLetterDifferentCasesUpperFirstMode() {
        testHelper("bAcaB", "AaBbc", Alphabetizer.UPPER_FIRST);
    }

    @Test
    public void testHelloWorld() {
        testHelper("Hello World", "deHllloorW");
    }

    @Test
    public void testVirginiaTech() {
        testHelper("VirginiaTech", "aceghiiinrTV");
    }

    @Test
    public void test3BlindMice() {
        testHelper("3 Blind Mice", "BcdeiilMn");
    }
}