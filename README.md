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
- 5000코인을 획득하면 스페셜 리워드로 아스키 아트가 콘솔창에 출력되고 게임 종료
- 50코인 미만이 될 경우 게임 종료

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
**Horse Racing**
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

**Horse Racing**
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
```
모든 입출력 클래스는 utils 패키지에 있는 static 입출력 클래스의 메서드를 통해서 로직 구현
```

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

---


> 각각의 미니 게임 컨트롤러는 GameController 인터페이스의 구현체입니다.

<br>

**GuessingNumberController**
```java
public class GuessingNumberController implements GameController {
    private final GameInputManager gameInputManager;
    private final GameOutputManager gameOutputManager;
    private final GameService gameService;

    public GuessingNumberController(
            final GameInputManager gameInputManager,
            final GameOutputManager gameOutputManager,
            final GameService gameService
    ) {
        this.gameInputManager = gameInputManager;
        this.gameOutputManager = gameOutputManager;
        this.gameService = gameService;
    }

    @Override
    public void start() throws IOException, InterruptedException {
        printWelcomeView();
        SimpleOutputUtils.printCurrentCoin();

        if (!readContinue()) {
            return;
        }

        SimpleOutputUtils.printDecreaseCoin();

        continueService();
        GameResult gameResult = gameService.getResult();
        gameOutputManager.printResult(gameResult);

        Coin.checkRemainingCoin();

        if (readReStart()) {
            start();
        }
    }
    
    private void printWelcomeView() {...}
    private boolean readContinue() throws IOException, InterruptedException {...}
    private void continueService() throws IOException, InterruptedException{...}
    private boolean readReStart() throws IOException, InterruptedException {...}
}
```

Mini Lotto 게임을 담당하는 컨트롤러 클래스입니다.
start() 메서드 내에서 프로세스 진행은 다음과 같습니다.
1. 웰컴 메시지로 게임 룰과 보상 안내 출력
2. 현재 잔여 코인 출력
3. 게임 진행여부 입력 받기
4. 코인 차감 출력
5. 게임진행
6. 서비스 담당 클래스에서 게임 결과 반환받기
7. 결과 출력
8. 남은 코인 확인
9. 재도전 여부 입력 받기

<br>

**GuessingNumberGame**
```java
public class GuessingNumberGame implements GameService {
    private GameResult gameResult;

    @Override
    public void start(String userInput) throws IllegalArgumentException {
        Random random = new Random();
        List<Integer> randomNumbers = new ArrayList<>();

        GuessNumbers guessNumbers = createGuessNumbers(userInput);

        for (int i = 0; i < 3; i++) {
            randomNumbers.add(random.nextInt(10));
        }

        ResultNumbers resultNumbers = new ResultNumbers(randomNumbers);

        boolean isWinner = resultNumbers.compareNumbers(guessNumbers);
        gameResult = new GuessingNumberGameResult(isWinner, resultNumbers);
    }

    @Override
    public GameResult getResult() {
        return gameResult;
    }
    
    private GuessNumbers createGuessNumbers(String input) {...}
}
```
GameService 인터페이스를 오버라이딩 한 start() 메서드를 통해서 게임 서비스 로직을 시작합니다.  
프로세스 진행은 다음과 같습니다.
1. 입력받은 유저의 번호를 인스턴스로 할당
2. 정답이 될 랜덤 번호 생성해서 인스턴스로 할당
3. 유저번호와 랜덤 번호 비교해서 정답 여부 할당
4. 게임 결과 인스턴스 생성 및 할당
---


<br><br>



**StoppingNumberController**
```java
public class StoppingNumberController implements GameController {
    private final GameInputManager gameInputManager;
    private final GameOutputManager gameOutputManager;
    private final GameService gameService;

    public StoppingNumberController(
            final GameInputManager gameInputManager,
            final GameOutputManager gameOutputManager,
            final GameService gameService
    ) {
        this.gameInputManager = gameInputManager;
        this.gameOutputManager = gameOutputManager;
        this.gameService = gameService;
    }

    @Override
    public void start() throws IOException, InterruptedException {
        printWelcomeView();
        SimpleOutputUtils.printCurrentCoin();

        if (!readContinue()) {
            return;
        }

        SimpleOutputUtils.printDecreaseCoin();

        gameService.start(null);
        continueService();
        GameResult gameResult = gameService.getResult();
        gameOutputManager.printResult(gameResult);

        Coin.checkRemainingCoin();

        if (readReStart()) {
            start();
        }
    }

    private void printWelcomeView() {...}
    private boolean readContinue() throws IOException, InterruptedException {...}
    private void continueService() throws IOException, InterruptedException {...}
    private boolean readReStart() throws IOException, InterruptedException {...}
}
```
10 Sec Timer 게임을 담당하는 컨트롤러 클래스입니다.
start() 메서드 내에서 프로세스 진행은 다음과 같습니다.
1. 웰컴 메시지로 게임 룰과 보상 안내 출력
2. 현재 잔여 코인 출력
3. 게임 진행여부 입력 받기
4. 코인 차감 출력
5. 게임진행 (시간측정이 필요하기 때문에 유저입력 전달 대신에 null을 전달해서 타이머 시작)
6. 게임진행
7. 서비스 담당 클래스에서 게임 결과 반환받기
8. 결과 출력
9. 남은 코인 확인
10. 재도전 여부 입력 받기

<br>

**StoppingNumberGame**
```java
public class StoppingNumberGame implements GameService {
    private GameResult gameResult;
    private Instant startTime;
    private Instant endTime;

    public StoppingNumberGame() {}

    @Override
    public void start(String userInput) {
        if (userInput == null) {
            startTime = Instant.now();

            return;
        }

        endTime = Instant.now();
        double stopTime = Duration.between(startTime, endTime).toNanos() * 0.000000001;
        boolean isWinner = calculateTime(stopTime);

        gameResult = new StoppingNumberGameResult(isWinner, stopTime);
    }

    @Override
    public GameResult getResult() {
        return gameResult;
    }

    private boolean calculateTime(double stopTime) {}
}
```
GameService 인터페이스를 오버라이딩 한 start() 메서드를 통해서 게임 서비스 로직을 시작합니다.  
프로세스 진행은 다음과 같습니다.
1. 컨트롤러에서 처음 start() 호출 시, 인자로 null을 전달받아서 시간측정을 시작.
2. 두번째 start() 호출 시, 유저 입력을 인자로 받아서 시간 측정을 종료.
3. 측정 시간을 변수에 할당하고 게임 결과 여부를 저장.
4. 게임 결과 인스턴스 생성 및 할당



---


<br><br>


**SpeedCodingController**
```java
public class SpeedCodingController implements GameController {
    private final GameInputManager gameInputManager;
    private final GameOutputManager gameOutputManager;
    private final GameService gameService;

    public SpeedCodingController(
            final GameInputManager gameInputManager,
            final GameOutputManager gameOutputManager,
            final GameService gameService
    ) {
        this.gameInputManager = gameInputManager;
        this.gameOutputManager = gameOutputManager;
        this.gameService = gameService;
    }

    @Override
    public void start() throws IOException, InterruptedException {
        printWelcomeView();
        SimpleOutputUtils.printCurrentCoin();

        if (!readContinue()) {
            return;
        }

        SimpleOutputUtils.printDecreaseCoin();

        gameService.start(null);
        continueService();
        GameResult gameResult = gameService.getResult();
        gameOutputManager.printResult(gameResult);

        Coin.checkRemainingCoin();

        if (readReStart()) {
            start();
        }
    }


    private void printWelcomeView() {...}
    private boolean readContinue() throws IOException, InterruptedException {...}
    private void continueService() throws IOException, InterruptedException {...}
    private boolean readReStart() throws IOException, InterruptedException {...}
}
```
Speed Coding 게임을 담당하는 컨트롤러 클래스입니다.
start() 메서드 내에서 프로세스 진행은 다음과 같습니다.
1. 웰컴 메시지로 게임 룰과 보상 안내 출력
2. 현재 잔여 코인 출력
3. 게임 진행여부 입력 받기
4. 코인 차감 출력
5. 게임진행 (시간측정이 필요하기 때문에 유저입력 전달 대신에 null을 전달해서 타이머 시작)
6. 게임진행
7. 서비스 담당 클래스에서 게임 결과 반환받기
8. 결과 출력
9. 남은 코인 확인
10. 재도전 여부 입력 받기

<br>

**SpeedCodingGame**
```java
public class SpeedCodingGame implements GameService {
    private GameResult gameResult;
    private Instant startTime;
    private Instant endTime;
    private SpeedCode speedCode;

    public SpeedCodingGame() {}

    @Override
    public void start(String userInput) throws InterruptedException {
        if (userInput == null) {
            startTime = Instant.now();
            speedCode = SpeedCode.getRandomSpeedCode();

            SimpleOutputUtils.print("🚀 난이도: " + String.valueOf(speedCode.getLevel()));
            SimpleOutputUtils.print("⏰ 제한시간: " + String.valueOf(speedCode.getLimitTime()) + "초");
            SimpleOutputUtils.print("🪙 보상: " + String.valueOf(speedCode.getReward()) + "코인");
            SimpleOutputUtils.breakLine(ONE);
            SimpleOutputUtils.print("────────────────── Code ──────────────────");
            SimpleOutputUtils.breakLine(ONE);
            SimpleOutputUtils.print(speedCode.getCode());
            SimpleOutputUtils.breakLine(ONE);
            SimpleOutputUtils.print("──────────────────────────────────────────");
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

            return;
        }

        endTime = Instant.now();

        boolean isPassed = passedWithinTimeLimit();
        boolean isCorrect = compareCode(userInput);

        boolean isWinner;

        if(isPassed && isCorrect) {
            isWinner = true;
        } else {
            isWinner = false;
        }

        gameResult = new SpeedCodingGameResult(isWinner, getDuration(), isPassed, isCorrect, speedCode.getReward());
    }

    @Override
    public GameResult getResult() {
        return gameResult;
    }
    
    private boolean compareCode(String userInput) {...}
    private boolean passedWithinTimeLimit() {...}
    private double getDuration() {...}
}
```
GameService 인터페이스를 오버라이딩 한 start() 메서드를 통해서 게임 서비스 로직을 시작합니다.  
프로세스 진행은 다음과 같습니다.
1. 컨트롤러에서 처음 start() 호출 시, 인자로 null을 전달받아서 시간측정을 시작
2. 두번째 start() 호출 시, 유저 입력을 인자로 받아서 시간 측정을 종료
3. 제한시간 통과 여부와 입력값 일치 여부를 변수에 할당
4. 제한시간과 입력값이 모두 통과 되었다면 게임 최종 결과를 변수에 할당
5. 게임 결과 인스턴스 생성 및 할당

---

<br><br>


**HorseRacingController**
```java
public class HorseRacingController implements GameController {
    private final GameInputManager gameInputManager;
    private final GameOutputManager gameOutputManager;
    private final GameService gameService;

    public HorseRacingController(
            final GameInputManager gameInputManager,
            final GameOutputManager gameOutputManager,
            final GameService gameService
    ) {
        this.gameInputManager = gameInputManager;
        this.gameOutputManager = gameOutputManager;
        this.gameService = gameService;
    }

    @Override
    public void start() throws IOException, InterruptedException {
        printWelcomeView();
        SimpleOutputUtils.printCurrentCoin();

        if (!readContinue()) {
            return;
        }

        SimpleOutputUtils.printDecreaseCoin();
        continueService();
        GameResult gameResult = gameService.getResult();
        gameOutputManager.printResult(gameResult);

        Coin.checkRemainingCoin();

        if (readReStart()) {
            start();
        }
    }

    private void printWelcomeView() {...}
    private boolean readContinue() throws IOException, InterruptedException {...}
    private void continueService() throws IOException, InterruptedException {...}
    private boolean readReStart() throws IOException, InterruptedException {...}
}
```
Horse Racing 게임을 담당하는 컨트롤러 클래스입니다.
start() 메서드 내에서 프로세스 진행은 다음과 같습니다.
1. 웰컴 메시지로 게임 룰과 보상 안내 출력
2. 현재 잔여 코인 출력
3. 게임 진행여부 입력 받기
4. 코인 차감 출력
5. 게임진행
7. 서비스 담당 클래스에서 게임 결과 반환받기
8. 결과 출력
9. 남은 코인 확인
10. 재도전 여부 입력 받기

<br>

**HorseRacingGame**
```java
public class HorseRacingGame implements GameService {
    private GameResult gameResult;
    private List<Horse> horses;
    private Horse[] track;

    @Override
    public void start(String userInput) throws InterruptedException {
        horses = new ArrayList<>();
        track = new Horse[51];

        for (int i = 1; i <= 5; i++) {
            Horse horse = new Horse(i, HorseColor.findByValue(i), track);
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
        
        boolean isWinner = isWinner(userInput);
        this.gameResult = new HorseRacingResult(isWinner, Race.getWinner(track));
    }

    @Override
    public GameResult getResult() {
        return gameResult;
    }

    private boolean isWinner(String userInput) {...}
}
```
GameService 인터페이스를 오버라이딩 한 start() 메서드를 통해서 게임 서비스 로직을 시작합니다.  
프로세스 진행은 다음과 같습니다.
1. Horse라는 Thread를 상속받은 인스턴스를 다섯 마리 생성하고 리스트에 추가
2. 각각의 말들의 스레드에게 작업시작
3. 모든 스레드들이 종료되기를 기다림
4. 유저입력을 기반으로 게임 결과 여부 할당
5. 게임 결과 인스턴스 생성 및 할당


<br>

**Horse**
```java
public class Horse extends Thread {
    private int number;
    private HorseColor horseColor;
    private int position;
    private boolean isFirst;
    private Horse[] track;
    
    public Horse(int number, HorseColor horseColor, Horse[] track) {
        this.number = number;
        this.horseColor = horseColor;
        this.track = track;
        position = 0;
    }

    @Override
    public void run() {
        while (position != Race.TRACK_LENGTH) {
            if(Race.isFinished(track)) {

                return;
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Race.moveForward(this, track);
        }
    }
    
    public int getNumber() {...}
    public int getPosition() {...}
    public void moveForward() {...}
    public void moveBackward() {...}
    public void setFirst(boolean isFirst) {...}
    public boolean isFirst() {...}
    public HorseColor getColor() {...}
}
```
쓰레드를 상속받는 클래스입니다.
해당 쓰래드는 Race에 있는 static메서드를 통해 트랙을 달려나갑니다.

<br>

**Race**
```java
public class Race {
    static int TRACK_LENGTH = 50;

    public static synchronized void moveForward(Horse horse, Horse[] track) {
        horse.setPriority(Thread.MIN_PRIORITY);

        int currentPosition = horse.getPosition();

        remove();
        horse.setFirst(isFirst(currentPosition, track));

        if (currentPosition == ZERO) {
            if (track[currentPosition + ONE] == null) {
                horse.moveForward();
                track[horse.getPosition()] = horse;
            }

        } else {
            if (track[currentPosition + ONE] == null) {
                track[currentPosition] = null;
                horse.moveForward();

                if (!horse.isFirst() && currentPosition + TWO <= TRACK_LENGTH && track[currentPosition + TWO] == null) {
                    horse.moveForward();
                }

                track[horse.getPosition()] = horse;
            } else {
                Horse caughtHorse = track[currentPosition + ONE];
                caughtHorse.moveBackward();
                track[caughtHorse.getPosition()] = caughtHorse;
                horse.moveForward();
                track[horse.getPosition()] = horse;
                printOutrun(horse, caughtHorse);


                if (track[horse.getPosition() + ONE] == null) {
                    track[horse.getPosition()] = null;
                    horse.moveForward();
                    track[horse.getPosition()] = horse;
                }
            }

        }
        
        printTrack(track);
        horse.setPriority(Thread.NORM_PRIORITY);
    }

    public static int getWinner(Horse[] track) {...}
    public static boolean isFinished(Horse[] track) {...}
    private static boolean isFirst(int currentPosition, Horse[] track) {...}
    private static void remove() {...}
    private static void printTrack(Horse[] track) {...}
    private static void printOutrun(Horse horse, Horse caughtHorse) {...}
}
```
말 스레드의 움직임을 담당하는 핵심 메서드 moveForward를 static 메서드로 가지는 클래스입니다.  
스레드들의 공유자원인 track에 대한 race condition해결을 위해 synchronized 키워드를 사용했습니다.  
앞 칸이 한 칸 비었다면 한 칸 전진, 두 칸 비었다면 두 칸 전진할 수 있습니다.
전방에 말이 있다면 스위칭을 진행하고 그 후에 한 칸 비었다면 한 칸 더 전진합니다.

<br><br>








