package com.minigame.demo.service;

import com.minigame.demo.domain.GameResult;

import java.time.Duration;
import java.time.Instant;

public class StoppingNumberGame implements GameService {
    private GameResult gameResult;
    private Instant startTime;
    private Instant endTime;

    public StoppingNumberGame() {}

    @Override
    public void start(String userInput) {
        // 여기서 유저의 시간측정시작하고 유저의 스탑입력을 기다렸다가 스탑되면 결과담기
        // 이줄에 텍스트랑 stop안내
        if (userInput == null) {
            startTime = Instant.now();

            return;
        }

        endTime = Instant.now();
        double stopTime = Duration.between(startTime, endTime).toNanos() * 0.000000001;
        boolean isWinner = calculateTime(stopTime);

        gameResult = new GameResult(isWinner);
        gameResult.setStopTime(stopTime);
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
