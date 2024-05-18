package com.minigame.demo.controller.game;

import com.minigame.demo.domain.Coin;
import com.minigame.demo.domain.result.GameResult;
import com.minigame.demo.service.GameService;
import com.minigame.demo.utils.SimpleInputUtils;
import com.minigame.demo.utils.SimpleOutputUtils;
import com.minigame.demo.view.input.game.GameInputManager;
import com.minigame.demo.view.output.game.GameOutputManager;

import java.io.IOException;

import static com.minigame.demo.constant.ANSIColor.ANSI_GREEN;
import static com.minigame.demo.constant.MeaningfulNumber.ONE_SECOND;
import static com.minigame.demo.constant.PrintMessage.EXIT_MESSAGE;

public class GuessingNumberController {
    private final GameService gameService;
    private final GameInputManager gameInputManager;
    private final GameOutputManager gameOutputManager;

    public GuessingNumberController(
            GameService gameService,
            GameInputManager gameInputManager,
            GameOutputManager gameOutputManager
    ) {
        this.gameService = gameService;
        this.gameInputManager = gameInputManager;
        this.gameOutputManager = gameOutputManager;
    }

    public void start() throws IOException, InterruptedException {
        printWelcomeView();
        SimpleOutputUtils.printCurrentCoin();

        boolean answer = readContinue();

        if (!answer) {
            return;
        }

        SimpleOutputUtils.printDecreaseCoin();

        continueService();
        GameResult gameResult = gameService.getResult();
        gameOutputManager.printResult(gameResult);




        if (readReStart()) {
            start();
        }
    }

    private void printWelcomeView() {
        gameOutputManager.printWelcomeView();
    }

    private boolean readReStart() throws IOException, InterruptedException {
        try {
            return SimpleInputUtils.readReStart();
        } catch (IllegalArgumentException e) {
            SimpleOutputUtils.printYesOrNo();
            Thread.sleep(ONE_SECOND);

            return readReStart();
        }
    }

    private boolean readContinue() throws IOException, InterruptedException {
        try {
            return SimpleInputUtils.readContinue();
        } catch (IllegalArgumentException e) {
            SimpleOutputUtils.printYesOrNo();
            Thread.sleep(ONE_SECOND);

            return readContinue();
        }
    }

    private void continueService() throws IOException, InterruptedException{
        try {
            if (Coin.getCoin() < 50) {
                SimpleOutputUtils.printNotEnoughCoin();
                SimpleOutputUtils.print(EXIT_MESSAGE, ANSI_GREEN);
                System.exit(0);
            }

            String userInput = gameInputManager.readUserInput();
            gameService.start(userInput);
        } catch(IllegalArgumentException e) {
            gameOutputManager.printReInputMessage();
            Thread.sleep(ONE_SECOND);

            continueService();
        }
    }
}
