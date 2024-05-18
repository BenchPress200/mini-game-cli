package com.minigame.demo;

import com.minigame.demo.controller.GuessingNumberController;
import com.minigame.demo.controller.MainController;
import com.minigame.demo.controller.SpeedCodingController;
import com.minigame.demo.controller.StoppingNumberController;
import com.minigame.demo.view.input.InputManager;
import com.minigame.demo.view.input.game.GuessingNumberInputManager;
import com.minigame.demo.view.input.game.SpeedCodingInputManager;
import com.minigame.demo.view.input.game.StoppingNumberInputManager;
import com.minigame.demo.view.output.OutputManager;
import com.minigame.demo.view.output.game.GuessingNumberOutputManager;
import com.minigame.demo.view.output.game.SpeedCodingOutputManager;
import com.minigame.demo.view.output.game.StoppingNumberOutputManager;

public class AppConfiguration {
    public MainController mainController() {
        return new MainController(
                guessingNumberController(),
                stoppingNumberController(),
                speedCodingController(),
                inputManager(),
                outputManager()
        );
    }

    public GuessingNumberController guessingNumberController() {
        return new GuessingNumberController(
                guessingNumberInputManager(),
                guessingNumberOutputManager()
        );
    }

    public StoppingNumberController stoppingNumberController() {
        return new StoppingNumberController(
                stoppingNumberInputManager(),
                stoppingNumberOutputManager()
        );
    }

    public SpeedCodingController speedCodingController() {
        return new SpeedCodingController(
                speedCodingInputManager(),
                speedCodingOutputManager()
        );
    }

    public GuessingNumberInputManager guessingNumberInputManager() {
        return new GuessingNumberInputManager();
    }

    public GuessingNumberOutputManager guessingNumberOutputManager() {
        return new GuessingNumberOutputManager();
    }

    public StoppingNumberInputManager stoppingNumberInputManager() {
        return new StoppingNumberInputManager();
    }

    public StoppingNumberOutputManager stoppingNumberOutputManager() {
        return new StoppingNumberOutputManager();
    }

    public SpeedCodingInputManager speedCodingInputManager() {
        return new SpeedCodingInputManager();
    }

    public SpeedCodingOutputManager speedCodingOutputManager() {
        return new SpeedCodingOutputManager();
    }

    public InputManager inputManager() {
        return new InputManager();
    }

    public OutputManager outputManager() {
        return new OutputManager();
    }
}
