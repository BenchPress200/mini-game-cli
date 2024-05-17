package com.minigame.demo.controller;

import com.minigame.demo.enums.GameType;
import com.minigame.demo.view.input.InputManager;
import com.minigame.demo.view.output.OutputManager;

import java.io.IOException;

public class MainController {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private final GuessingNumberController guessingNumberController;
    private final StoppingNumberController stoppingNumberController;
    private final SpeedCodingController speedCodingController;

    private final InputManager inputManager;
    private final OutputManager outputManager;

    public MainController(GuessingNumberController guessingNumberController,
                          StoppingNumberController stoppingNumberController,
                          SpeedCodingController speedCodingController,
                          InputManager inputManager,
                          OutputManager outputManager) {
        this.guessingNumberController = guessingNumberController;
        this.stoppingNumberController = stoppingNumberController;
        this.speedCodingController = speedCodingController;
        this.inputManager = inputManager;
        this.outputManager = outputManager;
    }

    public void start() throws IOException, InterruptedException {
        outputManager.printWelcomeView();
        outputManager.printGameList();

        GameType gameType = readUserChoice();

        while(true) {
            switch(gameType) {
                case GAME_EXIT:
                    System.out.println(ANSI_GREEN + "게임이 종료됩니다..." + ANSI_RESET);
                    break;

                case MINI_LOTTO:
                    clearScreen();
                    guessingNumberController.start();
                    break;

                case TIMER:
                    System.out.println("타이머 시작");
                    break;

                case SPEED_CODING:
                    System.out.println("스피드 코딩 시작");
                }
            }
    }

    private GameType readUserChoice() throws IOException, InterruptedException{
        try {
            return inputManager.readUserChoice();
        } catch (NumberFormatException e) {
            System.out.println("\n" + ANSI_RED + "공백없이 오직 1, 2, 3 또는 0만 입력가능합니다 !");
            System.out.println("다시 입력해주세요." + ANSI_RESET + "\n");
            Thread.sleep(3000);

            outputManager.printGameList();

            return readUserChoice();
        }
    }

    public static void clearScreen() {
        for (int i = 0; i < 80; i++) {
                System.out.println("");
        }
    }
}
