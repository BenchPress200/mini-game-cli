package com.minigame.demo.controller;

import com.minigame.demo.view.output.GuessingNumberOutputManager;

public class GuessingNumberController {
    private static final String BREAK_LINE = "\n";

    private final GuessingNumberOutputManager guessingNumberOutputManager;

    public GuessingNumberController(GuessingNumberOutputManager guessingNumberOutputManager) {
        this.guessingNumberOutputManager = guessingNumberOutputManager;
    }

    public void start() {
        guessingNumberOutputManager.printWelcomeView();
//        
    }
}
