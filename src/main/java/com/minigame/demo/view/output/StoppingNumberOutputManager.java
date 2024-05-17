package com.minigame.demo.view.output;

import com.minigame.demo.model.ResultNumbers;

import java.io.BufferedWriter;
import java.io.IOException;

public class StoppingNumberOutputManager {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    private static final String BREAK_LINE = "\n";


    private BufferedWriter bufferedWriter;

    public StoppingNumberOutputManager(BufferedWriter bufferedWriter) {
        this.bufferedWriter = bufferedWriter;
    }

    public void printWelcomeView() throws IOException {
        bufferedWriter.write("─────────────────────────────── 게임 설명 ───────────────────────────────");
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.write("▓ [start] 를 입력해서 타이머를 작동시킵니다.");
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.write("▓ 응답 이후부터 시간이 흐르고 정확히 10초가 되었을 때, [stop]을 입력합니다.");
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.write("▓ [stop] 을 입력했을 때 흐른 시간이 10초의 +-1 미만 이라면 보상을 지급합니다 !");
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.flush();
    }

    public void printResult(double result) throws IOException {
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.write("▓ 타이머: " + result);
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.write(BREAK_LINE);

        double diff = result - 10f;
        System.out.println(diff);
        if (Math.abs(diff) < 1) {
            bufferedWriter.write(ANSI_BLUE + "아무말도 못하는 컴퓨터를 상대로 승리했습니다 !");
            bufferedWriter.write(BREAK_LINE);
            bufferedWriter.write("보상으로" + ANSI_CYAN + " [300코인]" + ANSI_BLUE + "이 지급되었습니다 !" + ANSI_RESET);
            bufferedWriter.write(BREAK_LINE);
            bufferedWriter.flush();

            return;
        }

        bufferedWriter.write(ANSI_BLUE + "다음 기회에... 😥" + ANSI_RESET);
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.flush();

    }


}
