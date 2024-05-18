package com.minigame.demo.controller.game;

import com.minigame.demo.domain.GameResult;
import com.minigame.demo.service.GameService;
import com.minigame.demo.utils.SimpleInputUtils;
import com.minigame.demo.utils.SimpleOutputUtils;
import com.minigame.demo.view.input.game.GuessingNumberInputManager;
import com.minigame.demo.view.output.game.GuessingNumberOutputManager;

import java.io.IOException;

import static com.minigame.demo.constant.MeaningfulNumber.ONE_SECOND;

public class GuessingNumberController {
    private final GameService gameService;
    private final GuessingNumberInputManager guessingNumberInputManager;
    private final GuessingNumberOutputManager guessingNumberOutputManager;

    public GuessingNumberController(
            GameService gameService,
            GuessingNumberInputManager guessingNumberInputManager,
            GuessingNumberOutputManager guessingNumberOutputManager
    ) {
        this.gameService = gameService;
        this.guessingNumberInputManager = guessingNumberInputManager;
        this.guessingNumberOutputManager = guessingNumberOutputManager;
    }

    public void start() throws IOException, InterruptedException {
        printWelcomeView();

        boolean answer = readContinue();

        if (!answer) {
            return;
        }


        continueService();
        GameResult gameResult = gameService.getResult();
        guessingNumberOutputManager.printResult(gameResult);




        if (readReStart()) {
            start();
        }
    }

    private void printWelcomeView() {
        guessingNumberOutputManager.printWelcomeView();
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
            String userInput = guessingNumberInputManager.readUserInput();
            gameService.start(userInput);
        } catch(IllegalArgumentException e) {
            guessingNumberOutputManager.printReInputMessage();
            Thread.sleep(ONE_SECOND);

            continueService();
        }
    }
}
