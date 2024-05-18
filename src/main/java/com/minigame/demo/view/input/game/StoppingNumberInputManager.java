package com.minigame.demo.view.input.game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StoppingNumberInputManager {
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

    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    public StoppingNumberInputManager(BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        this.bufferedReader = bufferedReader;
        this.bufferedWriter = bufferedWriter;
    }

    public void readEndSign() throws IOException {
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.write("시간이 녹아내리는 중...🫠");
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.write(BREAK_LINE);
        bufferedWriter.write(ANSI_GREEN+ "[stop] 입력 시 타이머가 종료됩니다: " + ANSI_RESET);
        bufferedWriter.flush();
        String answer = bufferedReader.readLine();

        if (!answer.equals("stop")) {
            throw new IllegalArgumentException();
        }

    }

    public void readStartSign() throws IOException {
        bufferedWriter.write(ANSI_GREEN+ "[start] 입력 시 타이머가 시작됩니다 : " + ANSI_RESET);
        bufferedWriter.flush();
        String answer = bufferedReader.readLine();

        if (!answer.equals("start")) {
            throw new IllegalArgumentException();
        }


    }

    public boolean readYesOrNo() throws IOException {
        bufferedWriter.write(ANSI_GREEN+ "그럼 준비되셨나요? [y/n]: " + ANSI_RESET);
        bufferedWriter.flush();
        String answer = bufferedReader.readLine();

        if (answer.equals("y") || answer.equals("Y")) {
            return true;
        }

        if (answer.equals("n") || answer.equals("N")) {
            return false;
        }

        throw new IllegalArgumentException();
    }

    public boolean readReStart() throws IOException {
        bufferedWriter.write(ANSI_GREEN + "재도전하시겠습니까? [y/n]: " + ANSI_RESET);
        bufferedWriter.flush();

        String answer = bufferedReader.readLine();

        if (answer.equals("y") || answer.equals("Y")) {
            return true;
        }

        if (answer.equals("n") || answer.equals("N")) {
            return false;
        }

        throw new IllegalArgumentException();
    }


}
