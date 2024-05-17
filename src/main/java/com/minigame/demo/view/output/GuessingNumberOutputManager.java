package com.minigame.demo.view.output;

import com.minigame.demo.model.ResultNumbers;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

public class GuessingNumberOutputManager {
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

    private final BufferedWriter bufferedWriter;


    public GuessingNumberOutputManager(BufferedWriter bufferedWriter) {
        this.bufferedWriter = bufferedWriter;
    }

    public void printWelcomeView() throws IOException {
        bufferedWriter.write("─────────────────────────────── 게임 설명 ───────────────────────────────");
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.write("▓ 0부터 9사이의 정수를 띄워쓰기로 구분해서 입력합니다. (예시: 4 5 0)");
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.write("▓ 프로그램이 랜덤으로 숫자 3개를 생성합니다");
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.write("▓ 해당 숫자와 모두 일치할 경우 보상을 지급합니다!");
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.flush();
    }

    public void printResult(ResultNumbers resultNumbers, boolean result) throws IOException, InterruptedException {
        bufferedWriter.write("▓");
        bufferedWriter.flush();
        Random random = new Random();
        for (Integer number : resultNumbers.getNumbers()) {
            bufferedWriter.write(" ");
            bufferedWriter.flush();

            for(int i = 0; i < 50; i++) {
                bufferedWriter.write(String.valueOf(random.nextInt(10)));
                bufferedWriter.flush();
                Thread.sleep(100);
                bufferedWriter.write("\b");
                bufferedWriter.flush();
            }

            bufferedWriter.write( number + " ");
            bufferedWriter.flush();

            bufferedWriter.write("▓");
            bufferedWriter.flush();
        }

        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.write(BREAK_LINE);

        if (!result) {
            bufferedWriter.write(ANSI_BLUE + "다음 기회에... 😥" + ANSI_RESET);
            bufferedWriter.write(BREAK_LINE);
            bufferedWriter.flush();


            return;
        }

        bufferedWriter.write(ANSI_BLUE + "아무말도 못하는 컴퓨터를 상대로 승리했습니다 !");
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.write("보상으로 현재 코인의 개수가 세배가 되었습니다 !" + ANSI_RESET);
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.flush();
    }



}
