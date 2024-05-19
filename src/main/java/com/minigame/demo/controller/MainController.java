package com.minigame.demo.controller;


import com.minigame.demo.controller.game.GuessingNumberController;
import com.minigame.demo.controller.game.SpeedCodingController;
import com.minigame.demo.controller.game.StoppingNumberController;
import com.minigame.demo.domain.Coin;
import com.minigame.demo.enums.GameType;
import com.minigame.demo.utils.SimpleOutputUtils;
import com.minigame.demo.view.input.InputManager;
import com.minigame.demo.view.output.OutputManager;

import java.io.IOException;

import static com.minigame.demo.constant.ANSIColor.*;
import static com.minigame.demo.constant.MeaningfulNumber.*;
import static com.minigame.demo.constant.PrintMessage.EXIT_MESSAGE;


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
            printGameRule();
            printSpecialReward();
            printGameList();
            printCurrentCoin();

            GameType gameType = readUserChoice();
            SimpleOutputUtils.clearConsole();

            switch(gameType) {
                case GAME_EXIT:
                    printExitMessage();
                    System.exit(ZERO);
                    break;

                case MINI_LOTTO:
                    guessingNumberController.start();
                    SimpleOutputUtils.clearConsole();
                    break;

                case TIMER:
                    stoppingNumberController.start();
                    SimpleOutputUtils.clearConsole();
                    break;

                case SPEED_CODING:
                    speedCodingController.start();
                    SimpleOutputUtils.clearConsole();
                }
            }
    }


    private GameType readUserChoice() throws IOException, InterruptedException{
        try {
            return inputManager.readUserChoice();

        } catch (NumberFormatException e) {
            SimpleOutputUtils.clearConsole();
            outputManager.printReInputMessage();

            Thread.sleep(ONE_SECOND);

            outputManager.printGameList();

            return readUserChoice();
        }
    }

    private void printWelcomeView() {
        outputManager.printWelcomeView();
    }

    private void printExitMessage() {
        outputManager.printExitMessage();
    }

    private void printGameList() {
        outputManager.printGameList();
    }

    private void printCurrentCoin() {
        SimpleOutputUtils.printCurrentCoin();
    }

    private void printGameRule() {
        outputManager.printGameRule();
    }

    private void printSpecialReward() throws InterruptedException {
        if (Coin.getCoin() < MIN_COIN) {
            SimpleOutputUtils.printNotEnoughCoin();
            SimpleOutputUtils.print(EXIT_MESSAGE, ANSI_GREEN);
            System.exit(ZERO);
        }

        if (Coin.getCoin() > 5000) {
            outputManager.printSpecialReward();
            System.exit(ZERO);
        }
    }
}
