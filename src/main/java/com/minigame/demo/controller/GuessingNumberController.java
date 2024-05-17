package com.minigame.demo.controller;

import com.minigame.demo.model.GuessNumbers;
import com.minigame.demo.view.input.GuessingNumberInputManager;
import com.minigame.demo.view.output.GuessingNumberOutputManager;

import java.io.IOException;
import java.util.List;

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

        boolean answer = readYesOrNo();

        if (!answer) {
            return;
        }

        GuessNumbers guessNumbers = readGuessNumber();


    }


    private boolean readYesOrNo() throws IOException, InterruptedException {
        try {
            return guessingNumberInputManager.readYesOrNo();
        } catch (IllegalArgumentException e) {
            System.out.println("\n" + ANSI_RED + "y 또는 n 으로 대답해주세요!");
            System.out.println("다시 입력해주세요." + ANSI_RESET + "\n");
            Thread.sleep(2000);

            return readYesOrNo();
        }
    }

    private GuessNumbers readGuessNumber() throws IOException, InterruptedException {
        try {
            return guessingNumberInputManager.readGuessNumber();
        } catch (IllegalArgumentException e) {
            System.out.println("\n" + ANSI_RED + "앞 뒤 공백없이 0 ~ 9 사이의 정수 세 개만 띄워쓰기로 구분해서 입력해야 됩니다!");// 예외처리 할 차례
            System.out.println("다시 입력해주세요." + ANSI_RESET + "\n");
            Thread.sleep(2000);

            return readGuessNumber();
        }
    }
}
