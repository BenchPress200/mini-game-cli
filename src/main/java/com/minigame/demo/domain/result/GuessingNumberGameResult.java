package com.minigame.demo.domain.result;

import com.minigame.demo.domain.ResultNumbers;

public class GuessingNumberGameResult extends GameResult {
    private ResultNumbers resultNumbers;

    public GuessingNumberGameResult(boolean isWinner, ResultNumbers resultNumbers) {
        super(isWinner);
        this.resultNumbers = resultNumbers;
    }

    public ResultNumbers getResultNumbers() {
        return resultNumbers;
    }

}
