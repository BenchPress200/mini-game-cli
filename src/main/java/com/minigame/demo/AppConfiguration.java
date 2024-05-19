package com.minigame.demo;

import com.minigame.demo.controller.game.GameController;
import com.minigame.demo.controller.game.GuessingNumberController;
import com.minigame.demo.controller.MainController;
import com.minigame.demo.controller.game.SpeedCodingController;
import com.minigame.demo.controller.game.StoppingNumberController;
import com.minigame.demo.service.GameService;
import com.minigame.demo.service.GuessingNumberGame;
import com.minigame.demo.service.SpeedCodingGame;
import com.minigame.demo.service.StoppingNumberGame;
import com.minigame.demo.view.input.InputManager;
import com.minigame.demo.view.input.game.GameInputManager;
import com.minigame.demo.view.input.game.GuessingNumberInputManager;
import com.minigame.demo.view.input.game.SpeedCodingInputManager;
import com.minigame.demo.view.input.game.StoppingNumberInputManager;
import com.minigame.demo.view.output.OutputManager;
import com.minigame.demo.view.output.game.GameOutputManager;
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

    public GameController guessingNumberController() {
        return new GuessingNumberController(
                guessNumberGame(),
                guessingNumberInputManager(),
                guessingNumberOutputManager()
        );
    }

    public GameController stoppingNumberController() {
        return new StoppingNumberController(
                stoppingNumberGame(),
                stoppingNumberInputManager(),
                stoppingNumberOutputManager()
        );
    }

    public GameController speedCodingController() {
        return new SpeedCodingController(
                speedCodingGame(),
                speedCodingInputManager(),
                speedCodingOutputManager()
        );
    }

    public GameInputManager guessingNumberInputManager() {
        return new GuessingNumberInputManager();
    }

    public GameOutputManager guessingNumberOutputManager() {
        return new GuessingNumberOutputManager();
    }

    public GameInputManager stoppingNumberInputManager() {
        return new StoppingNumberInputManager();
    }

    public GameOutputManager stoppingNumberOutputManager() {
        return new StoppingNumberOutputManager();
    }

    public GameInputManager speedCodingInputManager() {
        return new SpeedCodingInputManager();
    }

    public GameOutputManager speedCodingOutputManager() {
        return new SpeedCodingOutputManager();
    }

    public InputManager inputManager() {
        return new InputManager();
    }

    public OutputManager outputManager() {
        return new OutputManager();
    }

    public GameService guessNumberGame() {
        return new GuessingNumberGame();
    }

    public GameService stoppingNumberGame() {
        return new StoppingNumberGame();
    }

    public GameService speedCodingGame() {
        return new SpeedCodingGame();
    }
}
