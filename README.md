# java-ladder

사다리 타기 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)


## 요구사항 목록

### 주요 객체 속성, 역할
#### Player
  - 이름을 가진다.
#### Ladder
  - 여러 개의 Line을 가진다.
  - 높이를 가진다.
#### Line
  - 폭을 가진다.
  - Step을 가진다.
  - Step이 이어지면 안된다.

### 입력 요구사항
- [ ] 게임을 시작하면 참여할 사람 이름을 입력 받는다.
  - [ ] 참여할 사람의 이름은 `,`로 구분된다.
  - [ ] 참여할 사람은 최소 2명이다.
  - [ ] 참여할 사람은 최대 13명이다.
  - [ ] 참여할 사람의 이름이 공백이거나 5자리를 초과하면 `IllegalArgumentException` 예외가 발생한다.
  - [ ] 참여할 사람의 이름이 중복되면 `IllegalArgumentException` 예외가 발생한다.
  - [ ] 참여할 사람에 null 값이 주어지면 `IllegalArgumentException` 예외가 발생한다.
- [ ] 참여할 사람을 입력 받으면 최대 사다리의 높이를 입력 받는다.
  - [ ] 최소 사다리의 높이는 참여하는 사람의 인원 수 이다.
  - [ ] 최대 사다리의 높이는 참여하는 사람의 인원 수의 2배이다.
  - [ ] 입력되는 사다리의 높이가 최소, 최대 범위 값을 벗어나면  `IllegalArgumentException` 예외가 발생한다. 
  - [ ] 양의 정수 외의 값이 입력되면 `IllegalArgumentException` 예외가 발생한다.

### 출력 요구사항
- [ ] 최대 사다리의 높이를 입력받으면, `실행결과`를 출력한다.
- [ ] `실행결과`를 출력하면, 참여한 사람의 이름과, 사다리의 결과를 출력한다.

