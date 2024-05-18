package com.minigame.demo.domain.result;

import com.minigame.demo.domain.ResultNumbers;

public class SpeedCodingGameResult extends StoppingNumberGameResult {
    private boolean isPassed;
    private boolean isCorrect;
    private int reward;

    public SpeedCodingGameResult(
            boolean isWinner,
            ResultNumbers resultNumbers,
            double stopTime,
            boolean isPassed,
            boolean isCorrect,
            int reward
    ) {
        super(isWinner, resultNumbers, stopTime);
        this.isPassed = isPassed;
        this.isCorrect = isCorrect;
        this.reward = reward;
    }

    public boolean isPassed() {
        return isPassed;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public int getReward() {
        return reward;
    }
}
