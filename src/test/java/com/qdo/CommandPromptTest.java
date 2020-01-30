package com.qdo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CommandPromptTest {
    CommandPrompt commandPrompt;

    @BeforeEach
    public void setup() {
        commandPrompt = new CommandPrompt();
    }

    @Test
    public void testSetMode() {
        int mode = Alphabetizer.UPPER_FIRST;
        commandPrompt.setMode(mode);
        assertEquals(mode, commandPrompt.getMode());

        mode = Alphabetizer.LOWER_FIRST;
        commandPrompt.setMode(mode);
        assertEquals(mode, commandPrompt.getMode());
    }

    @Test
    public void testRun() {
        assertTrue(commandPrompt.isRun());

        commandPrompt.setRun(false);
        assertFalse(commandPrompt.isRun());
    }
}
