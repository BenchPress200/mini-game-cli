package com.minigame.demo.model;

import java.util.List;

public class GuessNumbers extends Numbers {
    public GuessNumbers(List<Integer> guessNumbers) {
        super(guessNumbers);
    }

    public List<Integer> getNumbers() {
        return super.numbers;
    }
}
