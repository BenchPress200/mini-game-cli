package com.minigame.demo.controller.game;

import com.minigame.demo.domain.GameResult;
import com.minigame.demo.enums.SpeedCode;
import com.minigame.demo.service.GameService;
import com.minigame.demo.service.SpeedCodingGame;
import com.minigame.demo.utils.SimpleInputUtils;
import com.minigame.demo.utils.SimpleOutputUtils;
import com.minigame.demo.view.input.InputManager;
import com.minigame.demo.view.input.game.SpeedCodingInputManager;
import com.minigame.demo.view.output.game.SpeedCodingOutputManager;

import java.io.IOException;

import static com.minigame.demo.constant.ANSIColor.*;
import static com.minigame.demo.constant.MeaningfulNumber.ONE_SECOND;

public class SpeedCodingController {
    private final GameService gameService;
    private final SpeedCodingInputManager speedCodingInputManager;
    private final SpeedCodingOutputManager speedCodingOutputManager;

    public SpeedCodingController(
            GameService gameService,
            SpeedCodingInputManager speedCodingInputManager,
            SpeedCodingOutputManager speedCodingOutputManager
    ) {
        this.gameService = gameService;
        this.speedCodingInputManager = speedCodingInputManager;
        this.speedCodingOutputManager = speedCodingOutputManager;
    }

    public void start() throws IOException, InterruptedException {
        printWelcomeView();

        boolean answer = readContinue();

        if (!answer) {
            return;
        }

        gameService.start(null); // 시간 측정 시작
        continueService();
        GameResult gameResult = gameService.getResult();
        speedCodingOutputManager.printResult(gameResult);






        if (readReStart()) {
            start();
        }
    }

    private void printWelcomeView() {
        speedCodingOutputManager.printWelcomeView();
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
            String userInput = speedCodingInputManager.readUserInput();
            gameService.start(userInput);
        } catch(IllegalArgumentException e) {
            speedCodingOutputManager.printReInputMessage();
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
