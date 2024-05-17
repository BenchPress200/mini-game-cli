package com.minigame.demo.controller;

import com.minigame.demo.enums.SpeedCode;
import com.minigame.demo.model.SpeedCodingGame;
import com.minigame.demo.view.input.InputManager;
import com.minigame.demo.view.input.SpeedCodingInputManager;
import com.minigame.demo.view.output.SpeedCodingOutputManager;

import java.io.IOException;

public class SpeedCodingController {
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

    private final SpeedCodingInputManager speedCodingInputManager;
    private final SpeedCodingOutputManager speedCodingOutputManager;

    public SpeedCodingController(SpeedCodingInputManager speedCodingInputManager, SpeedCodingOutputManager speedCodingOutputManager) {
        this.speedCodingInputManager = speedCodingInputManager;
        this.speedCodingOutputManager = speedCodingOutputManager;
    }

    public void start() throws IOException, InterruptedException {
        InputManager.clearScreen();
        speedCodingOutputManager.printWelcomeView();

        boolean answer = readYesOrNo();

        if (!answer) {
            return;
        }


        SpeedCodingGame speedCodingGame = new SpeedCodingGame();
        SpeedCode speedCode = speedCodingGame.getSpeedCode();
        speedCodingOutputManager.printCode(speedCode);

        // 입력매니저와 함께 몇 초 후 시작합니다 문구 출력
        // 시간 카운팅
        // start!! 메시지와 함까 입력 버퍼 오픈
//        speedCodingInputManager.readUserCode();


        // 사용자 입력받으면 입력 시간출력과 함께 오타여부 출력
        // 제한시간통과했으면 파랑, 아니면 빨강
        // 함께 보상안네 혹은 메시지
        //재시작 여부확인
        // 모두 구현한 후 보상 변수 와 최종 보상 출력 물만들고
        // 열거클래스, 상수파일 제작
        // 전첵적인 파일구조 리팩토링
        // 상속구조 파악(2차상속까지)
        // 노션작성, 리드미 작성
        // 시간 남으면 테스트 코드 ㄱㄱ
    }

    private boolean readYesOrNo() throws IOException, InterruptedException {
        try {
            return speedCodingInputManager.readYesOrNo();
        } catch (IllegalArgumentException e) {
            System.out.println("\n" + ANSI_RED + "y 또는 n 으로 대답해주세요!");
            System.out.println("다시 입력해주세요." + ANSI_RESET + "\n");
            Thread.sleep(2000);

            return readYesOrNo();
        }
    }
}
