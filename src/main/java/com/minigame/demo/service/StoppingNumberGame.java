package com.minigame.demo.service;

import com.minigame.demo.domain.result.GameResult;
import com.minigame.demo.domain.result.StoppingNumberGameResult;

import java.time.Duration;
import java.time.Instant;

public class StoppingNumberGame implements GameService {
    private GameResult gameResult;
    private Instant startTime;
    private Instant endTime;

    public StoppingNumberGame() {}

    @Override
    public void start(String userInput) {
        if (userInput == null) {
            startTime = Instant.now();

            return;
        }

        endTime = Instant.now();
        double stopTime = Duration.between(startTime, endTime).toNanos() * 0.000000001;
        boolean isWinner = calculateTime(stopTime);

        gameResult = new StoppingNumberGameResult(isWinner, stopTime);
    }

    @Override
    public GameResult getResult() {
        return gameResult;
    }

    private boolean calculateTime(double stopTime) {
        if (Math.abs(10f - stopTime) < 1) {
            return true;
        }

        return false;
    }


}
