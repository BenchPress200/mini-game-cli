package com.minigame.demo;

import com.minigame.demo.controller.MainController;
import com.minigame.demo.controller.GuessingNumberController;
import com.minigame.demo.controller.SpeedCodingController;
import com.minigame.demo.controller.StoppingNumberController;
import com.minigame.demo.view.input.GuessingNumberInputManager;
import com.minigame.demo.view.input.InputManager;
import com.minigame.demo.view.input.SpeedCodingInputManager;
import com.minigame.demo.view.input.StoppingNumberInputManager;
import com.minigame.demo.view.output.GuessingNumberOutputManager;
import com.minigame.demo.view.output.OutputManager;
import com.minigame.demo.view.output.SpeedCodingOutputManager;
import com.minigame.demo.view.output.StoppingNumberOutputManager;

import java.io.*;

public class AppConfiguration {
    public MainController mainController() throws IOException {
        return new MainController(
                guessingNumberController(),
                stoppingNumberController(),
                speedCodingController(),
                inputManager(),
                outputManager()
        );
    }

    public GuessingNumberController guessingNumberController() throws IOException {
        return new GuessingNumberController(
                guessingNumberInputManager(),
                guessingNumberOutputManager()
        );
    }

    public StoppingNumberController stoppingNumberController() throws IOException {
        return new StoppingNumberController(
                stoppingNumberInputManager(),
                stoppingNumberOutputManager()
        );
    }

    public SpeedCodingController speedCodingController() throws IOException {
        return new SpeedCodingController(
                speedCodingInputManager(),
                speedCodingOutputManager()
        );
    }

    public GuessingNumberInputManager guessingNumberInputManager() {
        return new GuessingNumberInputManager(
                new BufferedReader(new InputStreamReader(System.in)),
                new BufferedWriter(new OutputStreamWriter(System.out))
        );
    }

    public GuessingNumberOutputManager guessingNumberOutputManager() {
        return new GuessingNumberOutputManager(new BufferedWriter(new OutputStreamWriter(System.out)));
    }

    public StoppingNumberInputManager stoppingNumberInputManager() {
        return new StoppingNumberInputManager(
                new BufferedReader(new InputStreamReader(System.in)),
                new BufferedWriter(new OutputStreamWriter(System.out))
        );
    }

    public StoppingNumberOutputManager stoppingNumberOutputManager() {
        return new StoppingNumberOutputManager(new BufferedWriter(new OutputStreamWriter(System.out)));
    }

    public SpeedCodingInputManager speedCodingInputManager() {
        return new SpeedCodingInputManager(
                new BufferedReader(new InputStreamReader(System.in)),
                new BufferedWriter(new OutputStreamWriter(System.out))
        );
    }

    public SpeedCodingOutputManager speedCodingOutputManager() {
        return new SpeedCodingOutputManager(new BufferedWriter(new OutputStreamWriter(System.out)));
    }

    public InputManager inputManager() {
        return new InputManager(
                new BufferedReader(new InputStreamReader(System.in)),
                new BufferedWriter(new OutputStreamWriter(System.out))
        );
    }

    public OutputManager outputManager() {
        return new OutputManager(new BufferedWriter(new OutputStreamWriter(System.out)));
    }
}
