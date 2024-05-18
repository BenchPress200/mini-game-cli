package com.minigame.demo;

import com.minigame.demo.controller.MainController;

import java.io.IOException;

// 보상 static변수로 적용
// 매번 메인컨트롤러로 들어올때마다 보상값확인
// 기준치를 넘었다면 스페셜 출력 보여주고 종료
// 2차상속거리찾기
// 팩토리 인스턴스들 모두 싱글톤으로??
// 설계도 그려서 노션
// 나머지 노션정리
// 리드미 작성
public class Application {
    public static void main(String[] args) throws IOException, InterruptedException {
        AppConfiguration appConfiguration = new AppConfiguration();
        MainController mainController = appConfiguration.mainController();

        mainController.start();
    }
}
