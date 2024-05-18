package com.minigame.demo.service;

import com.minigame.demo.enums.SpeedCode;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Random;

public class SpeedCodingGame {
    private List<String> codes;
    private Instant startTime;
    private Instant endTime;
    private SpeedCode recentCode;

    public SpeedCodingGame() {}

    public SpeedCode getSpeedCode() {
        Random random = new Random();
        SpeedCode[] SpeedCodes = SpeedCode.values();
        int randomNumber = random.nextInt(SpeedCodes.length);
        recentCode = SpeedCodes[randomNumber];

        return SpeedCodes[randomNumber];
    }

    public void startTimer() {
        startTime = Instant.now();
    }

    public void endTimer() {
        endTime = Instant.now();
    }

    public boolean getResult(String userCode) {
        return recentCode.getCode().equals(userCode);
    }

    public boolean passedWithinTimeLimit() {
        if (recentCode.getLimitTime() > Duration.between(startTime, endTime).toMillis() * 0.001) {
            return true;
        }

        return false;
    }

    public double getDuration() {
        return Duration.between(startTime, endTime).toMillis() * 0.001;
    }
}
