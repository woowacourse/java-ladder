# java-laddergame

사다리 타기 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 기능 구현 목록

### 참여자 입력

- [x] 입력 안내 메시지 출력
- [x] 참여할 사람 이름을 입력한다
    - [x] 이름은 최대 5글자까지 부여할 수 있다
    - [x] 사람 이름은 알파벳과 숫자로만 구성된다
    - [x] 참여자의 수는 1이상 100이하로 제한한다
    - [x] 사람 이름은 쉼표(,)를 기준으로 구분한다

### 게임 결과 입력

- [x] 입력 안내 메시지 출력
- [x] 게임 실행 결과를 입력한다.
    - [x] 게임 실행 결과는 최대 5글자까지 부여할 수 있다.
    - [x] 게임 실행 결과는 알파벳과 숫자로만 구성된다.
    - [x] 게임 실행 결과의 개수는 참여자의 수와 같다.
    - [x] 게임 실행 결과는 쉼표(,)를 기준으로 구분한다.

### 사다리 높이 입력

- [x] 입력 안내 메시지 출력
- [x] 사다리 높이를 입력한다
    - [x] 사다리 높이는 1이상 100이하의 자연수이다

### 사다리 생성

- [x] 사다리의 높이는 사용자가 입력한 높이이다
- [x] 각 행마다 랜덤으로 사다리 연결을 형성한다
    - [x] 같은 행의 사다리 가로선은 연속되지 않게 한다

### 사다리 게임 실행

- [x] 각 player는 초기 Position값을 부여받는다.

```
ex)
  List<String> player = [pobi, coli, tre]
  List<Integer> playerPositions = [0, 1, 2]
```

- [x] 사다리를 따라 이동한다.
    - [x] position 왼쪽에 가로선이 연결되어 있다면 왼쪽으로 이동한다
    - [x] position 오른쪽에 가로선이 연결되어 있다면 오른쪽으로 이동한다

```
playerPositions   0    1    2    3    4
Connection          T    F    T    F
                  |----|    |----|    |
resultPositions   1    0    3    2    4
```

### 사다리 출력

- [x] 결과 안내 메시지 출력
- [x] 참여자 이름을 입력 순서대로 출력한다
    - [x] 참여자들의 이름은 공백으로 구분한다
    - [x] 참여자 이름은 5글자를 기준으로 출력한다

- [x] 사다리를 출력한다.
    - [x] 사다리 세로선은 사용자 이름의 맨 오른쪽에 정렬한다
    - [x] 각 세로선이 연결되어 있다면, `|-----|` 로 가로선을 출력한다

- [x] 게임 실행 결과를 출력한다.
    - [x] 게임 실행 결과는 공백으로 구분한다
    - [x] 게임 실행 결과는 5글자를 기준으로 구분한다

```
    pobi  honux crong   jk 
        |-----|     |-----|
        |     |-----|     |
        |-----|     |     |
        |     |-----|     |
        |-----|     |-----|
    꽝    5000  꽝    3000
```

### 게임 결과 출력

- [x] 결과를 보고 싶은 사람을 입력받는다
- [x] 사다리 게임 실행결과를 출력한다
    - [x] all을 입력하면 전체 참여자의 실행결과를 출력한다
        - 예시
        ```
      실행 결과
      pobi : 꽝
      honux : 3000
      crong : 꽝
      jk : 5000
        ```
    - [x] 참여자 이름을 입력하면 개인별 결과를 출력한다
        - [x] 입력한 참여자의 이름이 없다면 재입력을 받는다.
    -[ ] 재입력 여부를 물어본다

### 1차 리뷰 개선사항

- domain/ladder - 사다리 높이 원시값을 Height로 포장
- domain/ladder - 연결여부를 Connection Enum으로 표현
- domain/people - 참여자 이름 원시값을 Name으로 포장
- view - 예외발생시 재입력을 받는 ExceptionHandledReader구현 > Controller에서 예외처리 분리
- view - 메시지를 구성하는 MessageResolver 클래스 구현
- view - 이름 출력 규칙 재구성(제한 글자 수 기준 왼쪽 정렬)
- ConnectionGenerator - Stream 활용을 통한 코드 단순화
- 관련 클래스끼리 패키지화
- 코드 format을 위반사항 검토 및 가독성 개선
- 컨벤션에 맞게 메소드 순서 수정
- 불필요한 static 메소드 인스턴스화

## 2단계 구현사항

### [domain]

- ladder/RowLine - 좌우 Connection에 따라 이동하는 move 구현
- ladder/Ladder - RowLine 배열 단위로 이동을 수행하는 move 구현
- gameelements/Element - 사다리의 출발/도착 노드를 Element로 추상화한 객체(이전의 Name)
- gameelementsElements - Element의 일급 컬렉션 객체
- LadderGame - 사다리 게임 결과(상위 노드-하위노드 맵핑 결과)를 인스턴스 변수로 가지는 객체
- LadderGame - 상위 노드의 이름을 조회하여 결과를 반환하는 기능 구현

### [view]

- view/ResultView - 하위노드 출력기능 구현
- view/ResultView - 플레이어 이름에 따라 결과 출력기능 구현

### [test]

- TrueFalseConnectionGenerator : `연결-비연결`을 반복하여 생성하는 generator
- LadderGameTest : input 값에 따라 사다리 게임 결과 테스트

## 2단계 개선사안

- 컨벤션!! 코드 컨벤션 2번 확인하기

## 2단계 - 1차 리팩터링 개선사안

- gameelements/Elements : 책임에 따라 Players와 Prizes로 분할
- gameelements/Players : 예약어 검증 책임 수행 (ReservedElementName 클래스에서 책임 이전)
- gameelements/Prizes : Players와 동일길이 검증 책임 수행(controller에서 책임 이전)
- ConnectionGenerator : 메소드명 변경 getConnections > generate
- ladder/Connection : connection.isConnected()를 통해 연결정보를 메세지로 전달
- Stream.toList와 중복된 상수화(unmodifiableList) 제거
- view/ResultView : StringJoiner를 통한 메세지 구성
- test/LadderGameTest : 테스트 단순화 및 책임 분할
    - test/RowLineTest : 연결 행(connections) 단위 이동 책임 테스트
    - test/LadderTest : List<RowLine> 단위 이동 책임 테스트
    - test/LadderGameTest : Player- Prize 매핑 결과 책임 테스트

### 2단계 - 2차 리팩터링 개선사안
- gameelements
  - Position : player index 원시값 포장
  - Player
    - 사다리를 타는 책임을 가진 Player 객체 생성
    - 예약어 검증 책임을 Players로부터 이전
  - Prize : 사다리 게임에서 위치와 이름 정보를 가진 Prize 객체 생성
  - Players : List<Player> 일급컬렉션으로 리팩터링
  - Prizes : List<Prize> 일급컬렉션으로 리팩터링


- Ladder : 메소드명 변경(getReusltIndex > climb) 
  - Players가 사다리 연결을 따라 Position을 변경


- LadderGame 
  - Ladder / Players / Prizes 멤버변수 추가
  - 생성자에 복잡한 로직 playGame() 메서드로 분리
  - index 의존 로직을 객체 간 메시지 전달로 리팩터링
  - Player Position과 일치하는 Position을 가진 Prize 매핑
- 불필요한 toString() 삭제
- test 코드 최적화

### 2단계 - 3차 리팩터링 개선사안
- RowLine : 예측가능한 메서드명으로 rename(checkRightPosition > canMoveRightPosition)
- LadderController : printPlayerResult를 예측가능한 메서드 getPlayerName으로 변경
- Prize : Position을 통한 비교검증 책임 이전 (Prizes > Prize)
- Player : 이름을 통한 비교검증 책임 이전 (Players > Player)
- test : 전반적인 오류 fix
- test : assertAll로 복수검증 감싸기
