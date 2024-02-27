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

- [ ] 입력 안내 메시지 출력
- [ ] 게임 실행 결과를 입력한다.
    - [x] 게임 실행 결과는 최대 5글자까지 부여할 수 있다.
    - [x] 게임 실행 결과는 알파벳과 숫자로만 구성된다.
    - [x] 게임 실행 결과의 개수는 참여자의 수와 같다.
    - [ ] 게임 실행 결과는 쉼표(,)를 기준으로 구분한다.

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

- [ ] 게임 실행 결과를 출력한다.
    - [ ] 게임 실행 결과는 공백으로 구분한다
    - [ ] 게임 실행 결과는 5글자를 기준으로 구분한다

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

- [ ] 결과를 보고 싶은 사람을 입력받는다
- [ ] 사다리 게임 실행결과를 출력한다
    - [ ] all을 입력하면 전체 참여자의 실행결과를 출력한다
        - 예시
            - ```
        실행 결과
        pobi : 꽝
        honux : 3000
        crong : 꽝
        jk : 5000
        ```
    - [ ] 참여자 이름을 입력하면 개인별 결과를 출력한다
        - [ ] 입력한 참여자의 이름이 없다면 재입력을 받는다.
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
