package com.minigame.demo.view.output;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.LinkedList;

public class GuessingNumberOutputManager {
    private static final String BREAK_LINE = "\n";

    private final BufferedWriter bufferedWriter;


    public GuessingNumberOutputManager(BufferedWriter bufferedWriter) {
        this.bufferedWriter = bufferedWriter;
    }

    public void printWelcomeView() throws IOException {
        bufferedWriter.write("─────────────────────────────── 게임 설명 ───────────────────────────────");
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.write("▓ 0부터 9사이의 정수를 띄워쓰기로 구분해서 입력합니다. (예시: 4, 5, 0)");
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.write("▓ 프로그램이 랜덤으로 숫자 3개를 생성합니다");
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.write("▓ 해당 숫자와 모두 일치할 경우 보상을 지급합니다!");
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.flush();
    }


}
