# java-ladder

사다리 타기 미션 저장소

## 요구사항 해석

- 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.
  - 이름은 최소 1글자, 최대 5글자이다. 
  - 이름으로 all을 입력할 수 없다.
- 사람 이름은 쉼표(,)를 기준으로 구분한다.
- 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
  - 사다리 폭은 6글자이다. 
  - 가로 줄이 없는 경우 `|     `, 있는 경우 `|-----`로 표현한다. 
- 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
- `|-----|-----|` 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.
- 사다리 실행 결과를 출력해야 한다.
- 개인별 이름을 입력하면 개인별 결과를 출력하고, "all"을 입력하면 전체 참여자의 실행 결과를 출력한다.
  - "all"을 입력하면 결과를 출력한 후 프로그램을 종료한다. 

### 추가한 요구사항

- 사다리 높이는 1 이상이다.
- 결과는 쉼표(,)로 구분해 입력한다.
  - 결과는 최소 1글자, 최대 5글자이다.

## 기능 목록

- [X] 이름 입력
  - [X] 예외
    - [X] 이름이 1-5자 범위를 벗어난 경우
    - [X] 이름이 중복된 경우
    - [ ] 이름으로 all을 입력한 경우
- [X] 높이 입력
  - [X] 예외
    - [X] 높이가 자연수가 아닌 경우
- [X] 실행 결과 입력
  - [X] 예외
    - [X] 결과가 1-5자 범위를 벗어난 경우
- [X] 사다리 생성
    - [X] 가로줄은 무작위로 생성
- [X] 사다리 생성 결과 출력
- [X] 사다리를 타고 이동
- [ ] 사다리 결과 보고 싶은 사람 입력
  - [X] 개인 이름을 입력하면 개인 결과 출력 (무한 반복)
  - [X] "all"을 입력하면 전체 결과 출력 후 프로그램 종료
  - [X] 예외
    - [X] 앞에서 입력되지 않은 이름을 입력하는 경우
- [X] 예외가 발생할 경우 다시 입력

## 예시

```
참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)
pobi,honux,crong,jk

최대 사다리 높이는 몇 개인가요?
5

실행결과

pobi  honux crong   jk
    |-----|     |-----|
    |     |-----|     |
    |-----|     |     |
    |     |-----|     |
    |-----|     |-----|

```

## 구현 아이디어

예시의 실행 결과를 그래프로 도식화하면 다음과 같습니다.

<img src="docs/images/ladder01.png" width="640"/>

그래프를 행렬로 표현했습니다. 

<img src="docs/images/ladder02.png" width="640"/>

각 칸은 세로줄을 의미하고, 1과 -1의 쌍은 가로줄을 의미합니다.  

즉 1은 오른쪽 방향을, -1은 왼쪽 방향을, 0은 방향이 없음을 의미합니다.

## 리팩토링 목록

- [X] Players List<String>이 아닌 List<Player>를 받도록 생성 로직 변경
- [ ] 사용자가 공백을 의도할 수 있으므로 입력에서 공백을 무시하지 않도록 변경
- [X] 객체의 관계를 명시하기 위해 ExceptionHandler와 View를 객체로 변경
- [X] LadderLevel -> LadderRow 이름 변경(readme 또한)
