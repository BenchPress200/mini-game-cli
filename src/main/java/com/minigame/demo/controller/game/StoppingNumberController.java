package com.minigame.demo.controller.game;

import com.minigame.demo.domain.GameResult;
import com.minigame.demo.service.GameService;
import com.minigame.demo.service.StoppingNumberGame;
import com.minigame.demo.utils.SimpleInputUtils;
import com.minigame.demo.utils.SimpleOutputUtils;
import com.minigame.demo.view.input.InputManager;
import com.minigame.demo.view.input.game.StoppingNumberInputManager;
import com.minigame.demo.view.output.game.StoppingNumberOutputManager;

import java.io.IOException;

import static com.minigame.demo.constant.MeaningfulNumber.ONE_SECOND;

public class StoppingNumberController {
    private final GameService gameService;
    private final StoppingNumberInputManager stoppingNumberInputManager;
    private final StoppingNumberOutputManager stoppingNumberOutputManager;

    public StoppingNumberController(
            GameService gameService,
            StoppingNumberInputManager stoppingNumberInputManager,
            StoppingNumberOutputManager stoppingNumberOutputManager
    ) {
        this.gameService = gameService;
        this.stoppingNumberInputManager = stoppingNumberInputManager;
        this.stoppingNumberOutputManager = stoppingNumberOutputManager;
    }

    public void start() throws IOException, InterruptedException {
        printWelcomeView();
        SimpleOutputUtils.printCurrentCoin();

        boolean answer = readContinue();

        if (!answer) {
            return;
        }



        gameService.start(null);
        continueService();
        GameResult gameResult = gameService.getResult();
        stoppingNumberOutputManager.printResult(gameResult);

        if (readReStart()) {
            start();
        }
    }

    private void printWelcomeView() {
        stoppingNumberOutputManager.printWelcomeView();
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

    private void continueService() throws IOException, InterruptedException {
        try {
            String userInput = stoppingNumberInputManager.readUserInput();
            gameService.start(userInput);
        } catch(IllegalArgumentException e) {
            stoppingNumberOutputManager.printReInputMessage();
            Thread.sleep(ONE_SECOND);

            continueService();
        }
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
}
