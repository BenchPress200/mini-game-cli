package com.minigame.demo.view.output.game;

import com.minigame.demo.domain.GameResult;
import com.minigame.demo.utils.SimpleOutputUtils;

import static com.minigame.demo.constant.ANSIColor.ANSI_BLUE;
import static com.minigame.demo.constant.ANSIColor.ANSI_CYAN;
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
        SimpleOutputUtils.print("▓ 타이핑 시간: " + gameResult.getStopTime());

        if (gameResult.isPassed()) {
            SimpleOutputUtils.print("▓ 제한시간 통과: ✅");

        } else {
            SimpleOutputUtils.print("▓ 제한시간 통과: ❌");
        }

        if (gameResult.isCorrect()) {
            SimpleOutputUtils.print("▓ 코드 일치 여부: ✅");
        } else {
            SimpleOutputUtils.print("▓ 코드 일치 여부: ❌");
        }

        SimpleOutputUtils.breakLine(ONE);

        if (gameResult.isWinner()) {
            SimpleOutputUtils.print(WIN_MESSAGE, ANSI_BLUE);
            SimpleOutputUtils.print("보상으로" + ANSI_CYAN + " [" + gameResult.getReward() + "]" + ANSI_BLUE + "이 지급되었습니다 !", ANSI_BLUE);

            return;
        }

        SimpleOutputUtils.print(NEXT_CHANCE_MESSAGE, ANSI_BLUE);
        SimpleOutputUtils.breakLine(ONE);
    }

    @Override
    public void printReInputMessage() {}
}
