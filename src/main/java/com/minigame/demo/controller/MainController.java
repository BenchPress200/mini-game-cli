package com.minigame.demo.controller;


import com.minigame.demo.enums.GameType;
import com.minigame.demo.utils.SimpleOutputUtils;
import com.minigame.demo.view.input.InputManager;
import com.minigame.demo.view.output.OutputManager;

import java.io.IOException;

import static com.minigame.demo.constant.ANSIColor.*;
import static com.minigame.demo.constant.PrintMessage.*;


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
        printWelcomeView();

        while(true) {
            printGameList();
            GameType gameType = readUserChoice();

            switch(gameType) {
                case GAME_EXIT:
                    SimpleOutputUtils.simplePrint(EXIT_MESSAGE, ANSI_GREEN);
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
            SimpleOutputUtils.clearConsole();
            SimpleOutputUtils.simplePrint(GAME_CHOICE_POSSIBLE_INPUT_MESSAGE, ANSI_RED);
            SimpleOutputUtils.simplePrint(RE_INPUT_MESSAGE, ANSI_RED);
            SimpleOutputUtils.breakLine(1);

            Thread.sleep(1000);

            outputManager.printGameList();

            return readUserChoice();
        }
    }

    private void printWelcomeView() throws IOException {
        outputManager.printWelcomeView();
    }

    private void printGameList() throws IOException {
        outputManager.printGameList();
    }
}
