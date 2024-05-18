package com.minigame.demo.service;

import com.minigame.demo.domain.GameResult;

public interface GameService {
    void start(String userInput);
    GameResult getResult();
}
