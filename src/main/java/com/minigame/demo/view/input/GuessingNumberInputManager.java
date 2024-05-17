package com.minigame.demo.view.input;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class GuessingNumberInputManager {
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
    private static final String YES = "YES";
    private static final String NO = "NO";

    private final BufferedReader bufferedReader;
    private final BufferedWriter bufferedWriter;

    public GuessingNumberInputManager(BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        this.bufferedReader = bufferedReader;
        this.bufferedWriter = bufferedWriter;
    }

    public String readYesOrNo() throws IOException, IllegalArgumentException {
        bufferedWriter.write(ANSI_GREEN+ "그럼 준비되셨나요? [y/n]: " + ANSI_RESET);
        bufferedWriter.flush();
        String answer = bufferedReader.readLine();

        if (answer.equals("y") || answer.equals("Y") || answer.equals("n") || answer.equals("N")) {
            return answer;
        }

        throw new IllegalArgumentException();
        // 0 ~ 9 사이의 정수 세 개를 띄워쓰기로 구분해서 입력해주세요:
    }


}
