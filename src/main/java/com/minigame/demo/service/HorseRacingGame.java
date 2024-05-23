package com.minigame.demo.service;

import com.minigame.demo.domain.result.GameResult;

public class HorseRacingGame implements GameService {
    private GameResult gameResult;

    @Override
    public void start(String userInput) throws InterruptedException {
        // 말이 될 쓰레드 10미리 쓰레드 풀에 생성
        // 유저가 선택한 말은 달리는 라인 다른 컬러로 표시
        // 열마리가 동시에 달리는데 각자 진행숫자가 존재하고 100까지 달리면 완주
        // 어떤말이 거리 1뒤로 뛰쫓는다면 자리 스위칭



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
