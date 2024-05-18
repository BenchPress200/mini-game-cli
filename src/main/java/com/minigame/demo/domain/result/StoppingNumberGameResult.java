package com.minigame.demo.domain.result;

import com.minigame.demo.domain.ResultNumbers;
import com.minigame.demo.domain.result.GuessingNumberGameResult;

public class StoppingNumberGameResult extends GuessingNumberGameResult {
    private double stopTime;

    public StoppingNumberGameResult(boolean isWinner, ResultNumbers resultNumbers, double stopTime) {
        super(isWinner, resultNumbers);
        this.stopTime = stopTime;
    }

    public double getStopTime() {
        return stopTime;
    }
}
