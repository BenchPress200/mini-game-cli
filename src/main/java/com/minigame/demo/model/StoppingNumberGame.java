package com.minigame.demo.model;

import java.time.Duration;
import java.time.Instant;

public class StoppingNumberGame {
    private Instant startTime;
    private Instant endTime;

    public StoppingNumberGame() {

    }

    public void startTimer() {
        startTime = Instant.now();
    }

    public void endTimer() {
        endTime = Instant.now();
    }

    public double getResult() {
        return Duration.between(startTime, endTime).toNanos() * 0.000000001;
    }
}
