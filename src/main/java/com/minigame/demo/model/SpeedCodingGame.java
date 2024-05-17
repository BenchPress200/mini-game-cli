package com.minigame.demo.model;

import com.minigame.demo.enums.SpeedCode;

import java.util.List;
import java.util.Random;

public class SpeedCodingGame {
    private List<String> codes;

    public SpeedCodingGame() {



    }

    public SpeedCode getSpeedCode() {
        Random random = new Random();
        SpeedCode[] SpeedCodes = SpeedCode.values();
        int randomNumber = random.nextInt(SpeedCodes.length);

        return SpeedCodes[randomNumber];
    }
}
