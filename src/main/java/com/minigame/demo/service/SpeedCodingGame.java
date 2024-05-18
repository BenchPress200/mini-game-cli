package com.minigame.demo.service;

import com.minigame.demo.domain.result.GameResult;
import com.minigame.demo.domain.result.SpeedCodingGameResult;
import com.minigame.demo.enums.SpeedCode;
import com.minigame.demo.utils.SimpleOutputUtils;

import java.time.Duration;
import java.time.Instant;

import static com.minigame.demo.constant.MeaningfulNumber.*;
import static com.minigame.demo.constant.ANSIColor.*;

public class SpeedCodingGame implements GameService {
    private GameResult gameResult;
    private Instant startTime;
    private Instant endTime;
    private SpeedCode speedCode;

    public SpeedCodingGame() {}

    @Override
    public void start(String userInput) throws InterruptedException {
        if (userInput == null) {
            startTime = Instant.now();
            speedCode = SpeedCode.getRandomSpeedCode();

            SimpleOutputUtils.print("🚀 난이도: " + String.valueOf(speedCode.getLevel()));
            SimpleOutputUtils.print("⏰ 제한시간: " + String.valueOf(speedCode.getLimitTime()) + "초");
            SimpleOutputUtils.print("🪙 보상: " + String.valueOf(speedCode.getReward()) + "코인");
            SimpleOutputUtils.breakLine(ONE);
            SimpleOutputUtils.print("────────────────── Code ──────────────────");
            SimpleOutputUtils.breakLine(ONE);
            SimpleOutputUtils.print(speedCode.getCode());
            SimpleOutputUtils.breakLine(ONE);
            SimpleOutputUtils.print("──────────────────────────────────────────");
            SimpleOutputUtils.print("5초 후 시작합니다 !");

            for (int i = FIVE; i > ZERO; i--) {
                if (i % 2 == 0) {
                    SimpleOutputUtils.printNoLineBreak(String.valueOf(i), ANSI_RED);
                } else {
                    SimpleOutputUtils.printNoLineBreak(String.valueOf(i), ANSI_CYAN);
                }
                Thread.sleep(ONE_SECOND);
                SimpleOutputUtils.removeCharacter();
            }

            SimpleOutputUtils.print("start !!!", ANSI_GREEN);

            return;
        }

        endTime = Instant.now();

        boolean isPassed = passedWithinTimeLimit();
        boolean isCorrect = compareCode(userInput);

        boolean isWinner;

        if(isPassed && isCorrect) {
            isWinner = true;
        } else {
            isWinner = false;
        }

        gameResult = new SpeedCodingGameResult(isWinner, null, getDuration(), isPassed, isCorrect, speedCode.getReward());
    }

    @Override
    public GameResult getResult() {
        return gameResult;
    }


    public boolean compareCode(String userInput) {
        if (speedCode.getCode().equals(userInput)) {
            return true;
        }

        return false;
    }

    public boolean passedWithinTimeLimit() {
        if (speedCode.getLimitTime() > getDuration()) {
            return true;
        }

        return false;
    }

    public double getDuration() {
        return Duration.between(startTime, endTime).toMillis() * 0.001;
    }
}
