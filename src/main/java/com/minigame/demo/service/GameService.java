package com.minigame.demo.service;

import com.minigame.demo.domain.result.GameResult;

public interface GameService {
    void start(String userInput) throws InterruptedException;
    GameResult getResult();
}
