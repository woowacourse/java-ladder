# java-ladder

사다리 타기 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 요구사항 목록

### 주요 객체 속성, 역할

#### Player

- 이름을 가진다.
- 이름은 1~5자리 이다.
- 이름이 공백이거나 5자리를 초과하면 `IllegalArgumentException` 예외가 발생한다.
- 이름에 null 값이 주어지면 `IllegalArgumentException` 예외가 발생한다.

### Players

- 여러 개의 `Player`를 가진다.
- `Player`의 이름이 중복되면 `IllegalArgumentException` 예외가 발생한다.

#### Ladder

- 여러 개의 `Line`을 가진다.
- `Line`의 크기는 `Players`의 인원 수의 1~2배 사이여야 한다.
- 인원 수 범위를 벗어나면 `IllegalArgumentException` 예외가 발생한다.
- `Height`를 가진다.

#### Line

- 여러 개의 `Step`을 가진다.
- `EXIST` 상태의 `Step`이 연속되면 `IllegalArgumentException` 예외가 발생한다.

#### Step

- `EMPTY` 또는 `EXIST`를 가진다.

#### Height

- 1~26 까지 값을 가진다.
- 이 외의 값이 들어오면 `IllegalArgumentException` 예외가 발생한다.

#### Results

- 여러 개의 `Result`를 가진다.
- `Result`의 갯수가 참여할 인원 수와 같지 않으면 `IllegalArgumentException` 예외가 발생한다.

#### Result

- 결과를 가진다.

### 기능 요구 사항
- [X] 사다리를 생성할 때 `Step`이 서로 연속되면 안된다.
- [ ] 참여한 인원의 사다리 결과를 맞춰야 한다.

### 입력 요구사항

- [X] 게임을 시작하면 참여할 사람 이름을 입력 받는다.
    - [X] 참여할 사람의 이름은 `,`로 구분된다.
- [X] 참여할 사람을 입력 받으면 최대 사다리의 높이를 입력 받는다.
    - [X] 최소 사다리의 높이는 참여하는 사람의 인원 수 이다.
    - [X] 최대 사다리의 높이는 참여하는 사람의 인원 수의 2배이다.
- [X] 사다리의 높이를 입력 받으면 실행 결과를 입력 받는다.
    - [X] 실행 결과는 `,`로 구분된다.
- [ ] 사다리 결과를 출력하면 결과를 보고 싶은 사람을 입력 받는다.
    - [ ] `all`을 입력하면 모든 사람의 결과를 출력한다. 

### 출력 요구사항

- [X] 최대 사다리의 높이를 입력받으면, `사다리 결과`를 출력한다.
- [X] `사다리 결과`를 출력하면, 참여한 사람의 이름과, 사다리의 결과, 실행 결과를 출력한다.
- [ ] 결과를 보고 싶은 사람을 입력 받으면 해당 입력에 대한 실행 결과를 출력한다.
