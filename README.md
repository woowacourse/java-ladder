# java-ladder

사다리 타기 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 요구사항 해석

- [ ] 이름을 입력받는다.
  - [x] 이름은 1글자 이상 5글자 이하로 구성된다.
  - [x] 이름은 쉼표로 구분된다.
  - [ ] 이름은 2명 이상 10명 이하로 구성된다.
  - [ ] 이름은 영어 대소문자, 숫자, '-', '_'로 구성된다.
  - [ ] 이름은 영어 대소문자를 구분한다.
  - [x] 👀 null, 빈 문자열은 예외로 처리한다.
  - [ ] 재입력은 5회로 제한하고, 6회부터 비정상 종료한다.

- [ ] 최대 사다리 높이를 입력받는다.
  - [ ] 높이는 1 이상 50 이하로 구성된다.
  - [ ] 👀 0 혹은 음의 정수를 입력하면 예외로 처리한다.
  - [ ] 👀 null, 빈 문자열은 예외로 처리한다.
  - [ ] 재입력은 5회로 제한하고, 6회부터 비정상 종료한다.

- [ ] 사다리를 생성한다.
  - [ ] 사다리는 2차원 배열로 표현된다.
// 고민사항: 사다리 객체를 표현하는 가장 단순한 방법이 2차원 배열이라고 생각하는데,
// 이를 출력하려면 2차원 배열 전체를 넘겨주는 방법 밖에는 생각하지 못헀다. 일급 컬렉션이 가진 멤버 변수를 그대로 전달하는 것에 문제가 없는지
  - [ ] 2차원 배열의 열은 사람 수이고, 행은 최대 사다리 높이이다.
  - [ ] 각 좌표의 값이 1이면 왼쪽 열과 이어지는 사다리가 있다.
  - [ ] 각 좌표의 값이 0이면 왼쪽 열과 이어지는 사다리가 없다.
    - [ ] 첫 번째 열의 값은 항상 0이다.
  - [ ] 각 사다리는 0~9 사이의 숫자에 의해 결정된다.
  - [ ] 해당 숫자가 5 이상인 경우 생성된다.
  - [ ] 단, 인접한 사다리가 있는 경우 생성되지 않는다.

- [ ] 결과를 출력한다.
  - [ ] 이름을 6칸에 맞게 앞에 공백을 채워 출력한다.
  - [ ] 사다리를 출력한다
    - [ ] 현재 좌표가 1이면 '-----|'을 출력한다.
    - [ ] 현재 좌표가 0이면 '     |'을 출력한다.

---

## 출력 예시
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

---

## 자바 코드 컨벤션을 지키면서 프로그래밍한다.
- 기본적으로 Java Style Guide을 원칙으로 한다.
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
- 3항 연산자를 쓰지 않는다.
- else 예약어를 쓰지 않는다.
- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
- 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
  - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.
- 배열 대신 컬렉션을 사용한다.
- Java Enum을 적용한다.
- 모든 원시 값과 문자열을 포장한다
- 일급 컬렉션을 쓴다.