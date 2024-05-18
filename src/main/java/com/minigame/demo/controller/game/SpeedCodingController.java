package com.minigame.demo.controller.game;

import com.minigame.demo.enums.SpeedCode;
import com.minigame.demo.service.SpeedCodingGame;
import com.minigame.demo.view.input.InputManager;
import com.minigame.demo.view.input.game.SpeedCodingInputManager;
import com.minigame.demo.view.output.game.SpeedCodingOutputManager;

import java.io.IOException;

import static com.minigame.demo.constant.ANSIColor.*;

public class SpeedCodingController {
    private static final String YES = "YES";
    private static final String NO = "NO";

    private static final String BREAK_LINE = "\n";

    private final SpeedCodingInputManager speedCodingInputManager;
    private final SpeedCodingOutputManager speedCodingOutputManager;

    public SpeedCodingController(SpeedCodingInputManager speedCodingInputManager, SpeedCodingOutputManager speedCodingOutputManager) {
        this.speedCodingInputManager = speedCodingInputManager;
        this.speedCodingOutputManager = speedCodingOutputManager;
    }

    public void start() throws IOException, InterruptedException {
        InputManager.clearScreen();
        speedCodingOutputManager.printWelcomeView();

        boolean answer = readYesOrNo();

        if (!answer) {
            return;
        }


        SpeedCodingGame speedCodingGame = new SpeedCodingGame();
        SpeedCode speedCode = speedCodingGame.getSpeedCode();
        speedCodingOutputManager.printCode(speedCode);

        speedCodingGame.startTimer();
        String userCode = speedCodingInputManager.readUserCode();
        speedCodingGame.endTimer();

        double duration = speedCodingGame.getDuration();
        boolean isCorrectCode = speedCodingGame.getResult(userCode);
        boolean passedWithinTimeLimit = speedCodingGame.passedWithinTimeLimit();

        speedCodingOutputManager.printResult(duration, isCorrectCode, passedWithinTimeLimit, String.valueOf(speedCode.getReward()));

        if (readReStart()) {
            start();
        }
    }

    private boolean readReStart() throws IOException, InterruptedException {
        try {
            return speedCodingInputManager.readReStart();
        } catch (IllegalArgumentException e) {
            System.out.println("\n" + ANSI_RED + "y 또는 n 으로 대답해주세요!");
            System.out.println("다시 입력해주세요." + ANSI_RESET + "\n");
            Thread.sleep(2000);

            return readReStart();
        }
    }

    private boolean readYesOrNo() throws IOException, InterruptedException {
        try {
            return speedCodingInputManager.readYesOrNo();
        } catch (IllegalArgumentException e) {
            System.out.println("\n" + ANSI_RED + "y 또는 n 으로 대답해주세요!");
            System.out.println("다시 입력해주세요." + ANSI_RESET + "\n");
            Thread.sleep(2000);

            return readYesOrNo();
        }
    }
}
