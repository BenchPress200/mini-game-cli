package com.minigame.demo;

import com.minigame.demo.controller.GuessingNumberController;
import com.minigame.demo.controller.MainController;
import com.minigame.demo.controller.SpeedCodingController;
import com.minigame.demo.controller.StoppingNumberController;
import com.minigame.demo.view.input.InputManager;
import com.minigame.demo.view.output.OutputManager;

public class Application {
    public static void main(String[] args) {
        MainController mainController = new MainController(
                new GuessingNumberController(),
                new StoppingNumberController(),
                new SpeedCodingController(),
                new InputManager(),
                new OutputManager()
        );

        mainController.start();
    }
}
