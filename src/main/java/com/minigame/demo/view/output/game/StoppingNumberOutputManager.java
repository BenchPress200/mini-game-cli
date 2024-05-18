package com.minigame.demo.view.output.game;

import com.minigame.demo.utils.SimpleOutputUtils;

import java.io.IOException;

import static com.minigame.demo.constant.ANSIColor.*;
import static com.minigame.demo.constant.PrintMessage.*;

public class StoppingNumberOutputManager {
    public StoppingNumberOutputManager() {}

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

    public void printReInputMessage() {
        SimpleOutputUtils.print(YES_OR_NO_INPUT_MESSAGE, ANSI_RED);
        SimpleOutputUtils.print(RE_INPUT_MESSAGE, ANSI_RED);
    }



}
