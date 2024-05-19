package com.minigame.demo.domain.result;

public class StoppingNumberGameResult extends GameResult {
    private double stopTime;

    public StoppingNumberGameResult(boolean isWinner, double stopTime) {
        super(isWinner);
        this.stopTime = stopTime;
    }

    public double getStopTime() {
        return stopTime;
    }
}
