# java-ladder

사다리 타기 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

# 2단계 - 사다리 게임 실행

## 요구사항 해석

- [x] 이름을 입력받는다.
  - [x] 이름은 1글자 이상 5글자 이하로 구성된다.
  - [x] 이름은 쉼표로 구분된다.
  - [x] 이름은 2명 이상 10명 이하로 구성된다.
  - [x] 이름은 영어 대소문자, 숫자, '-', '_'로 구성된다.
  - [x] 이름은 영어 대소문자를 구분한다.
  - [x] 👀 null, 빈 문자열은 예외로 처리한다.
  - [x] 재입력은 5회로 제한하고, 6회부터 비정상 종료한다.

- [x] 실행결과를 입력받는다.
  - [x] 결과는 1글자 이상 5글자 이하로 구성된다.
  - [x] 결과는 쉼표로 구분된다.
  - [x] 결과는 이름과 같은 2명 이상 10명 이하로 구성된다.
  - [x] 결과는 한글, 영어 대소문자, 숫자, '-', '_'로 구성된다.
  - [x] 결과는 영어 대소문자를 구분한다.
  - [x] 👀 null, 빈 문자열은 예외로 처리한다.
  - [x] 재입력은 5회로 제한하고, 6회부터 비정상 종료한다.

- [x] 최대 사다리 높이를 입력받는다.
  - [x] 높이는 1 이상 50 이하로 구성된다.
  - [x] 👀 정수 외의 값을 입력하면 예외로 처리한다.
  - [x] 👀 null, 빈 문자열은 예외로 처리한다.
  - [x] 재입력은 5회로 제한하고, 6회부터 비정상 종료한다.

- [x] 사다리를 생성한다.
  - [x] 사다리는 라인의 리스트다.
  - [x] 라인은 사다리 게임의 한 가로줄을 의미한다.
  - [x] 각 라인은 boolean 의 리스트다.
    - [x] 라인의 각 좌표의 값이 true 이면 왼쪽 열과 이어지는 사다리가 있다.
    - [x] 라인의 각 좌표의 값이 false 이면 왼쪽 열과 이어지는 사다리가 없다.
  - [x] 각 라인의 첫 번째 값은 항상 false 이다.
  - [x] 라인의 각 값은 0~9 사이의 숫자에 의해 결정된다.
    - [x] 해당 숫자가 5 이상인 경우 true 이다.
  - [x] 단, 라인의 이전 인덱스의 값이 true 인 경우 false 이다.

- [x] 결과를 보고 싶은 사람을 입력받는다.
  - [x] 결과를 보고 싶은 사람 입력은 이름 중 하나 혹은 'all' 만을 입력으로 받는다.
  - [x] 이름을 입력한 경우 그 이름에 따른 결과를 출력한다.
  - [x] 'all' 을 입력한 경우 모든 이름에 따른 결과를 출력한다.
  - [x] 그 외의 입력을 받은 경우 재입력을 받는다.
  - [x] 'all' 을 입력한 경우 프로그램을 종료한다.

## 출력 예시
```
참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)
pobi,honux,crong,jk

실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)
꽝,5000,꽝,3000

최대 사다리 높이는 몇 개인가요?
5

사다리 결과

pobi  honux crong   jk
    |-----|     |-----|
    |     |-----|     |
    |-----|     |     |
    |     |-----|     |
    |-----|     |-----|
꽝    5000  꽝    3000

결과를 보고 싶은 사람은?
pobi

실행 결과
꽝

결과를 보고 싶은 사람은?
all

실행 결과
pobi : 꽝
honux : 3000
crong : 꽝
jk : 5000
```

## 1단계 추가 피드백

- [x] LadderController - catch 문에서 예외 메시지 출력
- [x] getResult 분리 이후 단위 테스트
- [x] Line - 반복문 추출 - 명시적인 메서드로 분리
- [x] Name - isEmpty
- [x] CustomGenerator - 테스트 패키지로 이동, 공통 클래스로 만들어 참조
- [x] LadderController - 컨벤션 지키기

## 프로그래밍 요구 사항

- [자바 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java)을 지키면서 프로그래밍한다.
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


# 1단계 - 사다리 생성

## 요구사항 해석

- [x] 이름을 입력받는다.
  - [x] 이름은 1글자 이상 5글자 이하로 구성된다.
  - [x] 이름은 쉼표로 구분된다.
  - [x] 이름은 2명 이상 10명 이하로 구성된다.
  - [x] 이름은 영어 대소문자, 숫자, '-', '_'로 구성된다.
  - [x] 이름은 영어 대소문자를 구분한다.
  - [x] 👀 null, 빈 문자열은 예외로 처리한다.
  - [x] 재입력은 5회로 제한하고, 6회부터 비정상 종료한다.

- [x] 최대 사다리 높이를 입력받는다.
  - [x] 높이는 1 이상 50 이하로 구성된다.
  - [x] 👀 정수 외의 값을 입력하면 예외로 처리한다.
  - [x] 👀 null, 빈 문자열은 예외로 처리한다.
  - [x] 재입력은 5회로 제한하고, 6회부터 비정상 종료한다.

- [x] 사다리를 생성한다.
  - [x] 사다리는 라인의 리스트다.
  - [x] 라인은 사다리 게임의 한 가로줄을 의미한다.
  - [x] 각 라인은 boolean 의 리스트다.
    - [x] 라인의 각 좌표의 값이 true 이면 왼쪽 열과 이어지는 사다리가 있다.
    - [x] 라인의 각 좌표의 값이 false 이면 왼쪽 열과 이어지는 사다리가 없다.
  - [x] 각 라인의 첫 번째 값은 항상 false 이다.
  - [x] 라인의 각 값은 0~9 사이의 숫자에 의해 결정된다.
    - [x] 해당 숫자가 5 이상인 경우 true 이다.
  - [x] 단, 라인의 이전 인덱스의 값이 true 인 경우 false 이다.
  - [x] 라인은 출력을 위해 index 의 값을 반환한다.
  - [x] 사다리는 출력을 위해 게터를 통해 상태를 반환한다.

- [x] LadderString
  - [x] 사다리의 상태를 String으로 변환하는 클래스이다.

- [x] LineString
  - [x] Line의 상태를 String으로 변환하는 클래스이다.

- [x] 결과를 출력한다.
  - [x] 이름을 6칸에 맞게 앞에 공백을 채워 출력한다.
  - [x] 사다리를 출력한다
    - [x] 현재 좌표가 1이면 '-----|'을 출력한다.
    - [x] 현재 좌표가 0이면 '     |'을 출력한다.
  - [x] 사다리 출력은 enum으로 관리한다.

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