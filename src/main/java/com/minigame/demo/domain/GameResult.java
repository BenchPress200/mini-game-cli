package com.minigame.demo.domain;

import java.util.List;

public class GameResult {
    private boolean isWinner;
    private ResultNumbers resultNumbers;
    private double stopTime;
    private boolean isPassed;
    private boolean isCorrect;

    public GameResult(boolean isWinner) {
        this.isWinner = isWinner;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public ResultNumbers getResultNumbers() {
        return resultNumbers;
    }

    public void setResultNumbers(ResultNumbers resultNumbers) {
        this.resultNumbers = resultNumbers;
    }

    public double getStopTime() {
        return stopTime;
    }

    public void setStopTime(double stopTime) {
        this.stopTime = stopTime;
    }

    public boolean isPassed() {
        return isPassed;
    }

    public void setPassed(boolean passed) {
        isPassed = passed;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }



}
