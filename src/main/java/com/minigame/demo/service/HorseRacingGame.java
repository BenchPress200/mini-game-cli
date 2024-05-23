package com.minigame.demo.service;

import com.minigame.demo.domain.Horse;
import com.minigame.demo.domain.result.GameResult;
import com.minigame.demo.utils.SimpleOutputUtils;

import java.util.ArrayList;
import java.util.List;

import static com.minigame.demo.constant.ANSIColor.*;
import static com.minigame.demo.constant.MeaningfulNumber.*;

public class HorseRacingGame implements GameService {
    private GameResult gameResult;
    private List<Horse> horses = new ArrayList<>();

    @Override
    public void start(String userInput) throws InterruptedException {
        for (int i = 1; i <= 5; i++) {
            Horse horse = new Horse(i);
            horses.add(horse);
        }

        SimpleOutputUtils.breakLine(ONE);
        SimpleOutputUtils.print("5초 후 시작합니다 !");

        for (int i = FIVE; i > ZERO; i--) {
            if (i % 2 == 0) {
                SimpleOutputUtils.printNoLineBreak(String.valueOf(i), ANSI_RED);
            } else {
                SimpleOutputUtils.printNoLineBreak(String.valueOf(i), ANSI_CYAN);
            }
            Thread.sleep(ONE_SECOND);
            SimpleOutputUtils.removeCharacter();
        }

        SimpleOutputUtils.print("start !!!", ANSI_GREEN);


        for (Horse horse : horses) {
            horse.start();
        }

        for (Horse horse : horses) {
            horse.join();
        }

        // 끝나면 결과확인하고 담기




        // 게임결과 인스턴스 생성
        // 게임의 진행여부를 담아서 출력 클래스에서 게임어떻게 진행되었는지 출력해야함

        // 결과 인스턴스에는 우승여부
        // 못했다면 등수도 담기
    }

    @Override
    public GameResult getResult() {
        return null;
    }
}
