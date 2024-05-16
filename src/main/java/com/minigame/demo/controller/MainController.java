package com.minigame.demo.controller;

import com.minigame.demo.view.input.InputManager;
import com.minigame.demo.view.output.OutputManager;

public class MainController {
    private final GuessingNumberController guessingNumberController;
    private final StoppingNumberController stoppingNumberController;
    private final SpeedCodingController speedCodingController;

    private final InputManager inputManager;
    private final OutputManager outputManager;

    public MainController(GuessingNumberController guessingNumberController,
                          StoppingNumberController stoppingNumberController,
                          SpeedCodingController speedCodingController,
                          InputManager inputManager,
                          OutputManager outputManager) {
        this.guessingNumberController = guessingNumberController;
        this.stoppingNumberController = stoppingNumberController;
        this.speedCodingController = speedCodingController;
        this.inputManager = inputManager;
        this.outputManager = outputManager;
    }

    public void start() {
        // 입력에 따라서 다른 컨트롤러로 이동
    }
}
