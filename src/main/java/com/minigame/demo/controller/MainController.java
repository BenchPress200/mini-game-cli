package com.minigame.demo.controller;


import com.minigame.demo.domain.Coin;
import com.minigame.demo.enums.GameType;
import com.minigame.demo.utils.SimpleOutputUtils;
import com.minigame.demo.view.input.InputManager;
import com.minigame.demo.view.output.OutputManager;

import java.io.IOException;

import static com.minigame.demo.constant.ANSIColor.ANSI_GREEN;
import static com.minigame.demo.constant.MeaningfulNumber.*;
import static com.minigame.demo.constant.Message.EXIT_MESSAGE;


public class MainController implements GameController {
    private final InputManager inputManager;
    private final OutputManager outputManager;
    private final GameController guessingNumberController;
    private final GameController stoppingNumberController;
    private final GameController speedCodingController;
    private final GameController horseRacingController;

    public MainController(
            final InputManager inputManager,
            final OutputManager outputManager,
            final GameController guessingNumberController,
            final GameController stoppingNumberController,
            final GameController speedCodingController,
            final GameController horseRacingController
    ) {
        this.inputManager = inputManager;
        this.outputManager = outputManager;
        this.guessingNumberController = guessingNumberController;
        this.stoppingNumberController = stoppingNumberController;
        this.speedCodingController = speedCodingController;
        this.horseRacingController = horseRacingController;
    }

    @Override
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
                    break;
                case HORSE_RACING:
                    horseRacingController.start();
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

    private void printSpecialReward() {
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
