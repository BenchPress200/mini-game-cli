package com.minigame.demo.controller;

import com.minigame.demo.model.GuessNumberGame;
import com.minigame.demo.model.GuessNumbers;
import com.minigame.demo.view.input.game.GuessingNumberInputManager;
import com.minigame.demo.view.input.InputManager;
import com.minigame.demo.view.output.game.GuessingNumberOutputManager;

import java.io.IOException;

import static com.minigame.demo.constant.ANSIColor.*;

public class GuessingNumberController {
    private final GuessingNumberInputManager guessingNumberInputManager;
    private final GuessingNumberOutputManager guessingNumberOutputManager;

    public GuessingNumberController(GuessingNumberInputManager guessingNumberInputManager, GuessingNumberOutputManager guessingNumberOutputManager) {
        this.guessingNumberInputManager = guessingNumberInputManager;
        this.guessingNumberOutputManager = guessingNumberOutputManager;
    }

    public void start() throws IOException, InterruptedException {
        InputManager.clearScreen();
        guessingNumberOutputManager.printWelcomeView();

        boolean answer = readYesOrNo();

        if (!answer) {
            return;
        }

        GuessNumbers guessNumbers = readGuessNumber();
        GuessNumberGame guessNumberGame = new GuessNumberGame();
        guessNumberGame.createRandomNumbers();

        guessingNumberOutputManager.printResult(
                guessNumberGame.getResultNumbers(),
                guessNumberGame.getResult(guessNumbers)
        );

        if (readReStart()) {
            start();
        }
    }

    private boolean readReStart() throws IOException, InterruptedException {
        try {
            return guessingNumberInputManager.readReStart();
        } catch (IllegalArgumentException e) {
            System.out.println("\n" + ANSI_RED + "y 또는 n 으로 대답해주세요!");
            System.out.println("다시 입력해주세요." + ANSI_RESET + "\n");
            Thread.sleep(1000);

            return readReStart();
        }
    }


    private boolean readYesOrNo() throws IOException, InterruptedException {
        try {
            return guessingNumberInputManager.readYesOrNo();
        } catch (IllegalArgumentException e) {
            System.out.println("\n" + ANSI_RED + "y 또는 n 으로 대답해주세요!");
            System.out.println("다시 입력해주세요." + ANSI_RESET + "\n");
            Thread.sleep(1000);

            return readYesOrNo();
        }
    }

    private GuessNumbers readGuessNumber() throws IOException, InterruptedException {
        try {
            return guessingNumberInputManager.readGuessNumber();
        } catch (IllegalArgumentException e) {
            System.out.println("\n" + ANSI_RED + "앞 뒤 공백없이 0 ~ 9 사이의 정수 세 개만 띄워쓰기로 구분해서 입력해야 됩니다!");// 예외처리 할 차례
            System.out.println("다시 입력해주세요." + ANSI_RESET + "\n");
            Thread.sleep(1000);

            return readGuessNumber();
        }
    }
}
