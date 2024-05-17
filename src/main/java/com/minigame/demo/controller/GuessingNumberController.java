package com.minigame.demo.controller;

import com.minigame.demo.view.input.GuessingNumberInputManager;
import com.minigame.demo.view.output.GuessingNumberOutputManager;

import java.io.IOException;

public class GuessingNumberController {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    private static final String YES = "YES";
    private static final String NO = "NO";

    private static final String BREAK_LINE = "\n";

    private final GuessingNumberOutputManager guessingNumberOutputManager;
    private final GuessingNumberInputManager guessingNumberInputManager;

    public GuessingNumberController(GuessingNumberInputManager guessingNumberInputManager, GuessingNumberOutputManager guessingNumberOutputManager) {
        this.guessingNumberInputManager = guessingNumberInputManager;
        this.guessingNumberOutputManager = guessingNumberOutputManager;
    }

    public void start() throws IOException, InterruptedException {
        guessingNumberOutputManager.printWelcomeView();

        String answer = readYesOrNo();

    }


    private String readYesOrNo() throws IOException, InterruptedException {
        try {
            return guessingNumberInputManager.readYesOrNo();
        } catch (IllegalArgumentException e) {
            System.out.println("\n" + ANSI_RED + "y 또는 n 으로 대답해주세요!" + ANSI_RESET + "\n");
            Thread.sleep(2000);

            return readYesOrNo();
        }
    }
}
