package com.minigame.demo.controller.game;

import com.minigame.demo.service.StoppingNumberGame;
import com.minigame.demo.view.input.InputManager;
import com.minigame.demo.view.input.game.StoppingNumberInputManager;
import com.minigame.demo.view.output.game.StoppingNumberOutputManager;

import java.io.IOException;

public class StoppingNumberController {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    private static final String YES = "YES";
    private static final String NO = "NO";

    private static final String BREAK_LINE = "\n";

    private final StoppingNumberInputManager stoppingNumberInputManager;
    private final StoppingNumberOutputManager stoppingNumberOutputManager;

    public StoppingNumberController(StoppingNumberInputManager stoppingNumberInputManager, StoppingNumberOutputManager stoppingNumberOutputManager) {
        this.stoppingNumberInputManager = stoppingNumberInputManager;
        this.stoppingNumberOutputManager = stoppingNumberOutputManager;
    }

    public void start() throws IOException, InterruptedException {
        InputManager.clearScreen();
        stoppingNumberOutputManager.printWelcomeView();

        boolean answer = readYesOrNo();

        if (!answer) {
            return;
        }

        StoppingNumberGame stoppingNumberGame = new StoppingNumberGame();

        readStartSign();
        stoppingNumberGame.startTimer();
        readEndSign();
        stoppingNumberGame.endTimer();

        stoppingNumberOutputManager.printResult(stoppingNumberGame.getResult());





        if (readReStart()) {
            start();
        }

    }

    private boolean readReStart() throws IOException, InterruptedException {
        try {
            return stoppingNumberInputManager.readReStart();
        } catch (IllegalArgumentException e) {
            System.out.println("\n" + ANSI_RED + "y 또는 n 으로 대답해주세요!");
            System.out.println("다시 입력해주세요." + ANSI_RESET + "\n");
            Thread.sleep(2000);

            return readReStart();
        }
    }

    private void readEndSign() throws IOException, InterruptedException {
        try {
            stoppingNumberInputManager.readEndSign();
        } catch (IllegalArgumentException e) {
            System.out.println("\n" + ANSI_RED + "[stop] 입력 시 타이머가 종료됩니다 !");
            System.out.println("다시 입력해주세요." + ANSI_RESET + "\n");
            Thread.sleep(2000);
            readEndSign();
        }
    }

    private void readStartSign() throws IOException, InterruptedException {
        try {
            stoppingNumberInputManager.readStartSign();
        } catch (IllegalArgumentException e) {
            System.out.println("\n" + ANSI_RED + "[start] 입력 시 타이머가 시작됩니다 !");
            System.out.println("다시 입력해주세요." + ANSI_RESET + "\n");
            Thread.sleep(2000);

            readStartSign();
        }
    }

    private boolean readYesOrNo() throws IOException, InterruptedException {
        try {
            return stoppingNumberInputManager.readYesOrNo();
        } catch (IllegalArgumentException e) {
            System.out.println("\n" + ANSI_RED + "y 또는 n 으로 대답해주세요!");
            System.out.println("다시 입력해주세요." + ANSI_RESET + "\n");
            Thread.sleep(2000);

            return readYesOrNo();
        }
    }
}
