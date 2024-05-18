package com.minigame.demo.constant;

import static com.minigame.demo.constant.ANSIColor.ANSI_BLUE;
import static com.minigame.demo.constant.ANSIColor.ANSI_CYAN;

public class PrintMessage {
    public static final String EXIT_MESSAGE = "게임이 종료됩니다...";
    public static final String GAME_CHOICE_POSSIBLE_INPUT_MESSAGE = "공백없이 오직 1, 2, 3 또는 0만 입력가능합니다 !";
    public static final String RE_INPUT_MESSAGE = "다시 입력해주세요.";
    public static final String BLOCK_MESSAGE = "▓";
    public static final String SPACE = " ";
    public static final String WELCOME_MESSAGE =
            "   _    _        _                                  _             _    _                         _         _                                     _ \n" +
                    "  | |  | |      | |                                | |           | |  | |                       (_)       (_)                                   | |\n" +
                    "  | |  | |  ___ | |  ___   ___   _ __ ___    ___   | |_   ___    | |_ | |__    ___    _ __ ___   _  _ __   _     __ _   __ _  _ __ ___    ___   | |\n" +
                    "  | |/\\| | / _ \\| | / __| / _ \\ | '_ ` _ \\  / _ \\  | __| / _ \\   | __|| '_ \\  / _ \\  | '_ ` _ \\ | || '_ \\ | |   / _` | / _` || '_ ` _ \\  / _ \\  | |\n" +
                    "  \\  /\\  /|  __/| || (__ | (_) || | | | | ||  __/  | |_ | (_) |  | |_ | | | ||  __/  | | | | | || || | | || |  | (_| || (_| || | | | | ||  __/  |_|\n" +
                    "   \\/  \\/  \\___||_| \\___| \\___/ |_| |_| |_| \\___|   \\__| \\___/    \\__||_| |_| \\___|  |_| |_| |_||_||_| |_||_|   \\__, | \\__,_||_| |_| |_| \\___|  (_)\n" +
                    "                                                                                                                 __/ |                             ";
    public static final String GAME_LIST_MASSAGE =
            "───────────────────\n" +
            " 1⃣  🎱 미니 로또 - HARD\n" +
            " 2⃣  ⏰ 타이머 - EASY\n" +
            " 3⃣  🏎 스피드 코딩️ - MEDIUM\n" +
            " 0⃣  🚪 게임 종료 \n" +
            "───────────────────";
    public static final String GUESSING_NUMBER_WELCOME_MESSAGE =
            "─────────────────────────────── 게임 설명 ───────────────────────────────\n" +
            "▓ 0부터 9사이의 정수를 띄워쓰기로 구분해서 입력합니다. (예시: 4 5 0)\n" +
            "▓ 프로그램이 랜덤으로 숫자 3개를 생성합니다\n" +
            "▓ 해당 숫자와 모두 일치할 경우 보상을 지급합니다 !";
    public static final String NEXT_CHANCE_MESSAGE = "다음 기회에... 😥";
    public static final String WIN_MESSAGE = "아무말도 못하는 컴퓨터를 상대로 승리했습니다 !";
    public static final String REWARD_MESSAGE = "보상으로" + ANSI_CYAN + " [현재 코인 X 3]" + ANSI_BLUE + "(이)가 되었습니다 !";

}
