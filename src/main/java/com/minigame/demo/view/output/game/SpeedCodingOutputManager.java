package com.minigame.demo.view.output.game;

import com.minigame.demo.enums.SpeedCode;
import com.minigame.demo.utils.SimpleOutputUtils;

import java.io.IOException;

import static com.minigame.demo.constant.ANSIColor.*;
import static com.minigame.demo.constant.MeaningfulNumber.ONE;
import static com.minigame.demo.constant.MeaningfulNumber.ONE_SECOND;
import static com.minigame.demo.constant.PrintMessage.*;

public class SpeedCodingOutputManager {
    public SpeedCodingOutputManager() {}

    public void printWelcomeView() {
        SimpleOutputUtils.print(SPEED_CODING_WELCOME_MESSAGE);
        SimpleOutputUtils.breakLine(ONE);
    }

    public void printCode(SpeedCode speedCode) throws IOException, InterruptedException { // 얘를 모두 input으로 옮기기
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
            Thread.sleep(ONE_SECOND);
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
            SimpleOutputUtils.print(WIN_MESSAGE, ANSI_BLUE);
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

    public void printReInputMessage() {

    }

}
