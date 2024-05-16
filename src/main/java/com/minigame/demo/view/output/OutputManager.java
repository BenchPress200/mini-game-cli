package com.minigame.demo.view.output;

import java.io.BufferedWriter;
import java.io.IOException;

public class OutputManager {
    private static final int ZERO = 0;
    private static final int CONSOLE_END_INDEX = 150;
    private static final String BREAK_LINE = "\n";

    private final BufferedWriter bufferedWriter;

    public OutputManager(BufferedWriter bufferedWriter) {
        this.bufferedWriter = bufferedWriter;
    }

    public void printWelcomeView() throws IOException, InterruptedException {
        printHorizontalLine();
        bufferedWriter.write(BREAK_LINE);

        for (int i = ZERO; i < 1; i++) {
            printTextLine();
            bufferedWriter.write(BREAK_LINE);
        }

        printHorizontalLine();
        bufferedWriter.flush();
    }


    private void printTextLine() throws IOException {
        bufferedWriter.write("\n" +
                "   _    _        _                                  _             _    _                         _         _                                     _ \n" +
                "  | |  | |      | |                                | |           | |  | |                       (_)       (_)                                   | |\n" +
                "  | |  | |  ___ | |  ___   ___   _ __ ___    ___   | |_   ___    | |_ | |__    ___    _ __ ___   _  _ __   _     __ _   __ _  _ __ ___    ___   | |\n" +
                "  | |/\\| | / _ \\| | / __| / _ \\ | '_ ` _ \\  / _ \\  | __| / _ \\   | __|| '_ \\  / _ \\  | '_ ` _ \\ | || '_ \\ | |   / _` | / _` || '_ ` _ \\  / _ \\  | |\n" +
                "  \\  /\\  /|  __/| || (__ | (_) || | | | | ||  __/  | |_ | (_) |  | |_ | | | ||  __/  | | | | | || || | | || |  | (_| || (_| || | | | | ||  __/  |_|\n" +
                "   \\/  \\/  \\___||_| \\___| \\___/ |_| |_| |_| \\___|   \\__| \\___/    \\__||_| |_| \\___|  |_| |_| |_||_||_| |_||_|   \\__, | \\__,_||_| |_| |_| \\___|  (_)\n" +
                "                                                                                                                 __/ |                             \n" +
                "                                                                                                                |___/                              \n");
    }

    private void printHorizontalLine() throws IOException {
        for (int i = ZERO; i < CONSOLE_END_INDEX; i++) {
            bufferedWriter.write("▓");
        }
    }
}
