package com.minigame.demo.view.output.game;

import com.minigame.demo.domain.result.GameResult;
import com.minigame.demo.domain.result.SpeedCodingGameResult;
import com.minigame.demo.utils.SimpleOutputUtils;

import static com.minigame.demo.constant.ANSIColor.ANSI_BLUE;
import static com.minigame.demo.constant.MeaningfulNumber.ONE;
import static com.minigame.demo.constant.PrintMessage.*;

public class SpeedCodingOutputManager implements GameOutputManager {
    public SpeedCodingOutputManager() {}

    @Override
    public void printWelcomeView() {
        SimpleOutputUtils.print(SPEED_CODING_WELCOME_MESSAGE);
        SimpleOutputUtils.breakLine(ONE);
    }

    @Override
    public void printResult(GameResult gameResult) {
        SpeedCodingGameResult speedCodingGameResult = (SpeedCodingGameResult) gameResult;

        SimpleOutputUtils.print("▓ 타이핑 시간: " + speedCodingGameResult.getStopTime());

        if (speedCodingGameResult.isPassed()) {
            SimpleOutputUtils.print("▓ 제한시간 통과: ✅");

        } else {
            SimpleOutputUtils.print("▓ 제한시간 통과: ❌");
        }

        if (speedCodingGameResult.isCorrect()) {
            SimpleOutputUtils.print("▓ 코드 일치 여부: ✅");
        } else {
            SimpleOutputUtils.print("▓ 코드 일치 여부: ❌");
        }

        SimpleOutputUtils.breakLine(ONE);

        if (gameResult.isWinner()) {
            SimpleOutputUtils.print(WIN_MESSAGE, ANSI_BLUE);
            SimpleOutputUtils.printIncreaseCoin(speedCodingGameResult.getReward());

            return;
        }

        SimpleOutputUtils.print(NEXT_CHANCE_MESSAGE, ANSI_BLUE);
    }

    @Override
    public void printReInputMessage() {}
}
