package com.minigame.demo;

import com.minigame.demo.controller.MainController;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException, InterruptedException {
        AppConfiguration appConfiguration = new AppConfiguration();
        MainController mainController = appConfiguration.mainController();

        mainController.start();
    }
}
