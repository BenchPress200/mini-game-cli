package com.minigame.demo.enums;

import java.util.Random;

public enum SpeedCode {
    FIRST(
            "System.out.println();\n",
            10,
            1,
            100
    ),
    SECOND(
            "public static void main(String[] args) {}\n",
            10,
            2,
            200
    ),
    THIRD(
            "BufferedReader br = new BufferedReader(new InputStreamReader(System.in));\n" +
                    "BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));\n",
            30,
            3,
            300
    ),
    FOURTH(
            "for (int i = 0; i < 10; i++) {\n" +
                    "\tarr[i] = i;\n" +
                    "}\n",
            15,
            4,
            400
    ),
    FIFTH(
            "List<Integer> list = new ArrayList<>();\n" +
                    "\n" +
                    "for (Integer i : list) {\n" +
                    "\tSystem.out.println(i);\n" +
                    "}\n",
            20,
            4,
            400
    ),
    SIXTH(
        "_start:\n" +
                "\t; Initialize thread stacks\n" +
                "\tmov rax, stack1 + 1024\n" +
                "\tmov [thread1_rsp], rax\n" +
                "\tmov rax, stack2 + 1024\n" +
                "\tmov [thread2_rsp], rax\n" +
                "\n" +
                "\t; Set current_thread to thread1\n" +
                "\tmov rax, 1\n" +
                "\tmov [current_thread], rax\n" +
                "\n" +
                "\t; Jump to first thread\n" +
                "\tcall switch_to_thread1\n",
            60,
            5,
            1000
    ),
    SEVENTH(
            "section .data\n" +
                    "\tmsg db 'Hello, World!', 0\n" +
                    "\n" +
                    "section .text\n" +
                    "\tglobal _start\n" +
                    "\n" +
                    "_start:\n" +
                    "\t; Setup\n" +
                    "\tmov eax, 4\n" +
                    "\tmov ebx, 1\n" +
                    "\tlea ecx, [msg]\n" +
                    "\tmov edx, 13\n" +
                    "\n" +
                    "\t; Syscall\n" +
                    "\tint 0x80\n" +
                    "\n" +
                    "\t; Exit\n" +
                    "\txor eax, eax\n" +
                    "\tinc eax\n" +
                    "\txor ebx, ebx\n" +
                    "\tint 0x80\n",
            60,
            5,
            1000
    );

    private String code;
    private int limitTime;
    private int level;
    private int reward;

    SpeedCode(
            String code,
            int limitTime,
            int level,
            int reward) {
        this.code = code;
        this.limitTime = limitTime;
        this.level = level;
        this.reward = reward;
    }

    public String getCode() {
        return code;
    }

    public int getLimitTime() {
        return limitTime;
    }

    public int getLevel() {
        return level;
    }

    public int getReward() {
        return reward;
    }

    public static SpeedCode getRandomSpeedCode() {
        Random random = new Random();
        SpeedCode[] SpeedCodes = SpeedCode.values();
        int randomNumber = random.nextInt(SpeedCodes.length);

        return SpeedCodes[randomNumber];
    }
}
