package com.minigame.demo.view.output.game;

import com.minigame.demo.enums.SpeedCode;

import java.io.BufferedWriter;
import java.io.IOException;

public class SpeedCodingOutputManager {
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

    private BufferedWriter bufferedWriter;

    public SpeedCodingOutputManager(BufferedWriter bufferedWriter) {
        this.bufferedWriter = bufferedWriter;
    }

    public void printWelcomeView() throws IOException {
        bufferedWriter.write("─────────────────────────────── 게임 설명 ───────────────────────────────");
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.write("▓ 무작위로 코드가 생성됩니다.");
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.write("▓ 무작위 코드와 제한시간이 주어집니다.");
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.write("▓ 제한시간안에 탭과 띄어쓰기를 포함해서 제시된 코드와 똑같이 입력해야 합니다.");
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.write("▓ 유저는 코드 마지막 줄의 다음 줄에 0을 입력해주세요.");
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.write("▓ 오차없이 동일한 코드를 제한시간안에 입력했다면 보상을 지급합니다 !");
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.write("‼️코드의 난이도에 따라서 보상은 차등지급");
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.flush();
    }

    public void printCode(SpeedCode speedCode) throws IOException, InterruptedException {
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.write("🚀 난이도: " + String.valueOf(speedCode.getLevel()));
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.write("⏰ 제한시간: " + String.valueOf(speedCode.getLimitTime()) + "초");
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.write("🪙 보상: " + String.valueOf(speedCode.getReward()) + "코인");
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.write("────────────────── Code ──────────────────");
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.write(speedCode.getCode());
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.write("──────────────────────────────────────────");
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.flush();

        bufferedWriter.write("5초 후 시작합니다 !");
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.flush();
        for (int i = 5; i > 0; i--) {
            bufferedWriter.write(String.valueOf(i));
            bufferedWriter.flush();
            Thread.sleep(1000);
            bufferedWriter.write("\b");
            bufferedWriter.flush();
        }
        bufferedWriter.write("start !!!");
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.flush();

    }

    public void printResult(double duration, boolean isCorrectCode, boolean passedWithinTimeLimit, String reward) throws IOException {
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.write("▓ 타이핑 시간: " + duration);
        bufferedWriter.write(BREAK_LINE);
        if (passedWithinTimeLimit) {
            bufferedWriter.write("▓ 제한시간 통과: ✅");
        } else {
            bufferedWriter.write("▓ 제한시간 통과: ❌");
        }
        bufferedWriter.write(BREAK_LINE);
        if (isCorrectCode) {
            bufferedWriter.write("▓ 코드 일치 여부: ✅");
        } else {
            bufferedWriter.write("▓ 코드 일치 여부: ❌");
        }
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.write(BREAK_LINE);

        if (isCorrectCode && passedWithinTimeLimit) {
            bufferedWriter.write(ANSI_BLUE + "아무말도 못하는 컴퓨터를 상대로 승리했습니다 !");
            bufferedWriter.write(BREAK_LINE);
            bufferedWriter.write("보상으로" + ANSI_CYAN + " [" + reward + "]" + ANSI_BLUE + "이 지급되었습니다 !" + ANSI_RESET);
            bufferedWriter.write(BREAK_LINE);
            bufferedWriter.flush();

            return;
        }



        bufferedWriter.write(ANSI_BLUE + "다음 기회에... 😥" + ANSI_RESET);
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.flush();

    }

}
