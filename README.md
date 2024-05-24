**✅ Last Updated 2024-05-24**
- 4번째 미니게임 추가 

---

<br><br><br>

# Java CLI Mini Game
````
콘솔을 통해서 실행할 수 있는 미니 게임입니다.

총 4 가지의 게임이 존재하고 매번 선택함으로써 하나의 게임을 실행할 수 있습니다.
난이도는 4 개 모두 다르며, 각 게임마다 보상이 존재합니다.
보상은 코인으로 받게 되며, 일정 코인을 넘어섰을 경우 스페셜 아스키 아트를 콘솔창에서 만나실 수 있습니다.
````
<br>

## Primary Features
- 메인 뷰를 통해서 미니 게임 4개 중 택 1 가능
- 미니 게임 종료 후 재도전 혹은 다른 게임 선택 가능
- 게임 시작 시 코인이 기본으로 500 주어짐
- 각각의 게임을 시도하면 50코인 차감
- 게임에서 승리하면 보상으로 코인획득 가능
- 5000코인을 획득하면 스페셜 리워드로 아스키 아트가 콘솔창에 출력되고 게임 종료됨
- 50코인 미만이 될 경우 게임 종료됨

<br>

---

**Mini Lotto**
````
0 부터 9사이의 정수 중에서 중복허용해서 총 3개를 입력합니다.  
프로그램이 랜덤으로 3개의 수를 만들어서 콘솔에 출력합니다.  
3개의 숫자를 순서에 맞게 맞춰야 보상을 획득할 수 있습니다.
````

---

**10 Sec Timer Challenge**
````
게임 시작 시 타이머가 시작됩니다.
10초가 예상되는 타이밍에 “stop”을 입력합니다.
10초의 +-1오차로 “stop”을 입력했다면 보상을 획득합니다.
````

---

**Speed Coding**
````
콘솔에 랜덤으로 코드가 출력됩니다.
코드마다 보상과 제한 시간이 다르며, 난이도가 레벨로 표시됩니다.
시간에서 똑같이 타이핑하고 마지막줄에 “0”입력으로 정답을 제출합니다.
제한시간안에 코드를 정확하게 똑같이 작성했다면 보상을 획득합니다.  
✅ 탭, 띄어쓰기 포함
````

---
**Horse racing**
```
1번 부터 5번의 말중에서 선택합니다.
원하는 말을 입력하면 5초 후 경마가 시작됩니다.
앞서는 말의 한 칸 뒤까지 접근한다면 서로 위치가 반전될 수 있습니다.
1등이 결승선을 통과하면 게임이 종료됩니다.
오직 1등을 맞춰야 보상을 획득할 수 있습니다.
```

---

<br><br><br>

## Demo

**Mini Lotto**
![lotto.gif](resource%2Flotto.gif)

<br><br>

**10 Sec Timer Challenge**
![timer.gif](resource%2Ftimer.gif)

<br><br>

**Speed Coding**
![speed.gif](resource%2Fspeed.gif)

<br><br>

**Horse racing**
![race.gif](resource%2Frace.gif)






<br><br><br>




## Project Architecture

![이미지 설명](resource/image2.png)

---

**✅ 적용 디자인 패턴**

- **MVC**
- **Factory Method**

**✅ 프로세스 흐름**

1. AppConfiguration을 통해서 MainController를 반환받고 start() 호출
2. MainController 내부에서 유저의 입력에 따라서 미니 게임 담당 컨트롤러 start() 호출
3. MainController 를 포함하여 총 4개의 컨트롤러는 자신의 입출력 인스턴스를 사용하여 I/O작업 수행
4. 모든 입출력 클래스는 utils 패키지에 있는 static 입출력 클래스의 메서드를 통해서 로직 구현

<br><br><br>

## Details - 주요 클래스 설명

<br>

**AppConfiguration**
````java
public class AppConfiguration {
    public MainController mainController() {
        return new MainController(...);
    }
    
    .
    .
    .
    
}
````
AppConfiguration에서 Factory Method 패턴적용  
해당 클래스 내에서 컨트롤러와 입출력 클래스, 서비스 담당 클래스를 메서드 호출을 통해 생성






<br><br>


**Application**
````java
public class Application {
    public static void main(String[] args) throws IOException, InterruptedException {
        AppConfiguration appConfiguration = new AppConfiguration();
        MainController mainController = appConfiguration.mainController();

        mainController.start();
    }
}
````
AppConfiguration을 통해서 MainController 인스턴스 생성
MainController의 start() 메서드 호출을 통해 컨트롤 로직 실행


<br><br>

**SimpleInputUtils**  
```
각 컨트롤러에 입력 담당 클래스가 필드로 있음
모든 입력 담당 클래스는 SimpleInputUtils의 메서드를 사용해서 구현
```


<br><br>


**SimpleOutputUtils**
```
각 컨트롤러에 출력 담당 클래스가 필드로 있음
모든 출력 담당 클래스는 SimpleOutputUtils의 메서드를 사용해서 구현
```

<br><br>

**InputManager**
```
메인 컨트롤러와 미니 게임들의 컨트롤러가 각각 존재하므로 총 5개의 컨트롤러 클래스가 있음
컨트롤러 클래스에서 멤버로 갖는 입력 담당 클래스
컨트롤러의 개수만큼 있으므로 총 5개의 입력 매니저 클래스 존재
```

<br><br>

**OutputManager**
```
컨트롤러 클래스에서 멤버로 갖는 출력 담당 클래스
컨트롤러의 개수만큼 있으므로 총 5개의 출력 매니저 클래스 존재
```

<br><br>


**MainController**
```java
public class MainController implements GameController {
    private final InputManager inputManager;
    private final OutputManager outputManager;
    private final GameController guessingNumberController;
    private final GameController stoppingNumberController;
    private final GameController speedCodingController;
    private final GameController horseRacingController;

    public MainController(
            final InputManager inputManager,
            final OutputManager outputManager,
            final GameController guessingNumberController,
            final GameController stoppingNumberController,
            final GameController speedCodingController,
            final GameController horseRacingController
    ) {
        this.inputManager = inputManager;
        this.outputManager = outputManager;
        this.guessingNumberController = guessingNumberController;
        this.stoppingNumberController = stoppingNumberController;
        this.speedCodingController = speedCodingController;
        this.horseRacingController = horseRacingController;
    }

    @Override
    public void start() throws IOException, InterruptedException {
        printWelcomeView();

        while(true) {
            printGameRule();
            printSpecialReward();
            printGameList();
            printCurrentCoin();

            GameType gameType = readUserChoice();
            SimpleOutputUtils.clearConsole();

            switch(gameType) {
                case GAME_EXIT:
                    printExitMessage();
                    System.exit(ZERO);
                    break;

                case MINI_LOTTO:
                    guessingNumberController.start();
                    SimpleOutputUtils.clearConsole();
                    break;

                case TIMER:
                    stoppingNumberController.start();
                    SimpleOutputUtils.clearConsole();
                    break;

                case SPEED_CODING:
                    speedCodingController.start();
                    SimpleOutputUtils.clearConsole();
                    break;
                case HORSE_RACING:
                    horseRacingController.start();
                    SimpleOutputUtils.clearConsole();
                }
            }
    }


    private GameType readUserChoice() throws IOException, InterruptedException{...}
    private void printWelcomeView() {...}
    private void printExitMessage() {...}
    private void printGameList() {...}
    private void printCurrentCoin() {...}
    private void printGameRule() {...}
    private void printSpecialReward() {...}
}

```
메인 컨트롤러에서 유저의 입력을 받고 선택한 미니게임에 해당하는 컨트롤러 로직 실행  
입력된 값은 GameType 이라는 enum 타입으로 사용 


<br><br>


**GuessingNumberGame**
```java
public class GuessingNumberGame implements GameService {
    private GameResult gameResult;

    @Override
    public void start(String userInput) throws IllegalArgumentException {...}

    @Override
    public GameResult getResult() {...}
    
    private GuessNumbers createGuessNumbers(String input) {...}
}

```
각 게임 컨트롤러에서는 게임에 대한 서비스로직 담당 클래스 존재  
모든 서비스로직 클래스는 GameService 인터페이스의 구현체  
start()와 getResult()를 구현하고, 내부에서 필요힌 메서드를 private으로 선언해서 사용


<br><br>








