package com.minigame.demo.controller;

import com.minigame.demo.view.input.GuessingNumberInputManager;
import com.minigame.demo.view.input.InputManager;
import com.minigame.demo.view.input.StoppingNumberInputManager;
import com.minigame.demo.view.output.GuessingNumberOutputManager;
import com.minigame.demo.view.output.StoppingNumberOutputManager;

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

    public void start() throws IOException {
        InputManager.clearScreen();
        stoppingNumberOutputManager.printWelcomeView();

        // 시작여부 예스이후 시간이 흐르고
        // 정확히 소수점둘째자리까지해서 10초에 stop을 입력시 성공
        // 소수점 안맞춰도 정답 인정
        // 게임시작 여부묻는 메시지
        // 시작하면 시간이 녹아내리는 중...
        // 유저가 stop입력하면 그 때 멈춤
        // 입력하면 결과 확인하고 정답인지 아닌지 확인하고 메시지 출력하고
        // 재시작 여부 ㄱㄱ
    }
}
