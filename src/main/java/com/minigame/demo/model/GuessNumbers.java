package com.minigame.demo.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class GuessNumbers extends Numbers {
    public GuessNumbers(List<Integer> guessNumbers) {
        super(guessNumbers);
    }

    public List<Integer> getNumbers() {
        return super.numbers;
    }


}
