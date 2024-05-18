package com.minigame.demo.domain;

import java.util.List;

public class ResultNumbers extends Numbers {
    public ResultNumbers(List<Integer> resultNumbers) {
        super(resultNumbers);

    }

    public List<Integer> getNumbers() {
        return super.numbers;
    }
}
