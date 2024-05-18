package com.minigame.demo.controller;


import com.minigame.demo.enums.GameType;
import com.minigame.demo.view.input.InputManager;
import com.minigame.demo.view.output.OutputManager;

import java.io.IOException;

import static com.minigame.demo.constant.ANSIColor.*;


public class MainController {
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

        while(true) {
            outputManager.printGameList();
            GameType gameType = readUserChoice();

            switch(gameType) {
                case GAME_EXIT:
                    System.out.println(ANSI_GREEN + "게임이 종료됩니다..." + ANSI_RESET);
                    System.exit(0);
                    break;

                case MINI_LOTTO:
                    guessingNumberController.start();
                    inputManager.clearScreen();
                    break;

                case TIMER:
                    stoppingNumberController.start();
                    inputManager.clearScreen();
                    break;

                case SPEED_CODING:
                    speedCodingController.start();
                    inputManager.clearScreen();
                }
            }
    }

    private GameType readUserChoice() throws IOException, InterruptedException{
        try {
            return inputManager.readUserChoice();
        } catch (NumberFormatException e) {
            System.out.println();
            System.out.println(ANSI_RED + "공백없이 오직 1, 2, 3 또는 0만 입력가능합니다 !");
            System.out.println("다시 입력해주세요." + ANSI_RESET);
            System.out.println();

            Thread.sleep(2000);

            inputManager.clearScreen();
            outputManager.printGameList();

            return readUserChoice();
        }
    }
}
