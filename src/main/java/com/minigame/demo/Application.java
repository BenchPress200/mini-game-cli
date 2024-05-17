package com.minigame.demo;

import com.minigame.demo.controller.GuessingNumberController;
import com.minigame.demo.controller.MainController;
import com.minigame.demo.controller.SpeedCodingController;
import com.minigame.demo.controller.StoppingNumberController;
import com.minigame.demo.view.input.GuessingNumberInputManager;
import com.minigame.demo.view.input.InputManager;
import com.minigame.demo.view.output.GuessingNumberOutputManager;
import com.minigame.demo.view.output.OutputManager;

import java.io.*;


public class Application {
    public static void main(String[] args) throws IOException, InterruptedException {
        MainController mainController = new MainController(
                new GuessingNumberController(
                        new GuessingNumberInputManager(new BufferedReader(new InputStreamReader(System.in)), new BufferedWriter(new OutputStreamWriter(System.out))),
                        new GuessingNumberOutputManager(new BufferedWriter(new OutputStreamWriter(System.out)))),
                new StoppingNumberController(),
                new SpeedCodingController(),
                new InputManager(new BufferedReader(new InputStreamReader(System.in)), new BufferedWriter(new OutputStreamWriter(System.out))),
                new OutputManager(new BufferedWriter(new OutputStreamWriter(System.out)))
        );

        mainController.start();
    }
}
