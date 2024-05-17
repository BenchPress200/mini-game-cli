package com.minigame.demo.controller;

import com.minigame.demo.view.output.GuessingNumberOutputManager;

import java.io.IOException;

public class GuessingNumberController {
    private static final String BREAK_LINE = "\n";

    private final GuessingNumberOutputManager guessingNumberOutputManager;

    public GuessingNumberController(GuessingNumberOutputManager guessingNumberOutputManager) {
        this.guessingNumberOutputManager = guessingNumberOutputManager;
    }

    public void start() throws IOException {
        guessingNumberOutputManager.printWelcomeView();

    }
}
