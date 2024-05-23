package com.minigame.demo.domain.result;

public class HorseRacingResult extends GameResult {
    private int winnerHorseNumber;

    public HorseRacingResult(boolean isWinner, int winnerHorseNumber) {
        super(isWinner);
        this.winnerHorseNumber = winnerHorseNumber;
    }

    public int getWinnerHorseNumber() {
        return winnerHorseNumber;
    }
}
