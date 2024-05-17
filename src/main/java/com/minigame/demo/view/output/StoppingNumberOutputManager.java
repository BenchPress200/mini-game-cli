package com.minigame.demo.view.output;

import java.io.BufferedWriter;
import java.io.IOException;

public class StoppingNumberOutputManager {
    private static final String BREAK_LINE = "\n";

    private BufferedWriter bufferedWriter;

    public StoppingNumberOutputManager(BufferedWriter bufferedWriter) {
        this.bufferedWriter = bufferedWriter;
    }

    public void printWelcomeView() throws IOException {
        bufferedWriter.write("─────────────────────────────── 게임 설명 ───────────────────────────────");
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.write("▓ 게임시작 여부에 응답합니다.");
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.write("▓ 응답 이후부터 시간이 흐르고 정확히 10초가 되었을 때, stop을 입력합니다.");
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.write("▓ stop을 입력했을 때 흐른 시간이 10초 이상 11초 미만 이라면 보상을 지급합니다 !");
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.flush();
    }
}
