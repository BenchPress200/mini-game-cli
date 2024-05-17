package com.minigame.demo.enums;

public enum SpeedCode {
    FIRST(
            "System.out.println();",
            10,
            1,
            100
    ),
    SECOND(
            "public static void main(String[] args) {}",
            10,
            2,
            200
    ),
    THIRD(
            "BufferedReader br = new BufferedReader(new InputStreamReader(System.in));\n" +
                    "BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));",
            20,
            3,
            300
    ),
    FOURTH(
            "for (int i = 0; i < 10; i++) {\n" +
                    "   arr[i] = i;\n" +
                    "}",
            10,
            4,
            400
    ),
    FIFTH(
            "List<Integer> list = new ArrayList<>();\n" +
                    "\n" +
                    "for (Integer i : list) {\n" +
                    "   System.out.println(i);\n" +
                    "}",
            15,
            4,
            400
    ),
    SIXTH(
        "_start:\n" +
                "   ; Initialize thread stacks\n" +
                "   mov rax, stack1 + 1024\n" +
                "   mov [thread1_rsp], rax\n" +
                "   mov rax, stack2 + 1024\n" +
                "   mov [thread2_rsp], rax\n" +
                "\n" +
                "   ; Set current_thread to thread1\n" +
                "   mov rax, 1\n" +
                "   mov [current_thread], rax\n" +
                "\n" +
                "   ; Jump to first thread\n" +
                "   call switch_to_thread1",
            30,
            5,
            1000
    ),
    SEVENTH(
            "section .data\n" +
                    "   msg db 'Hello, World!', 0\n" +
                    "\n" +
                    "section .text\n" +
                    "   global _start\n" +
                    "\n" +
                    "_start:\n" +
                    "   ; Setup\n" +
                    "   mov eax, 4\n" +
                    "   mov ebx, 1\n" +
                    "   lea ecx, [msg]\n" +
                    "   mov edx, 13\n" +
                    "\n" +
                    "   ; Syscall\n" +
                    "   int 0x80\n" +
                    "\n" +
                    "   ; Exit\n" +
                    "   xor eax, eax\n" +
                    "   inc eax\n" +
                    "   xor ebx, ebx\n" +
                    "   int 0x80",
            30,
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
}
