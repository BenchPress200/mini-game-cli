package com.minigame.demo.controller.game;

import com.minigame.demo.controller.GameController;
import com.minigame.demo.service.GameService;
import com.minigame.demo.view.input.game.GameInputManager;
import com.minigame.demo.view.output.game.GameOutputManager;

import java.io.IOException;

public class HorseRacingController implements GameController {
    private final GameInputManager gameInputManager;
    private final GameOutputManager gameOutputManager;
    private final GameService gameService;

    public HorseRacingController(
            GameInputManager gameInputManager,
            GameOutputManager gameOutputManager,
            GameService gameService
        ) {
        this.gameInputManager = gameInputManager;
        this.gameOutputManager = gameOutputManager;
        this.gameService = gameService;
    }

    @Override
    public void start() throws IOException, InterruptedException {

    }
}
