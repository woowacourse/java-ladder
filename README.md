# java-ladder

사다리 타기 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 용어 정의

+ 사다리(ladder) : 라인의 집합

```
  |-----|     |-----|
  |     |-----|     |
  |-----|     |     |
  |     |-----|     |
  |-----|     |-----|
```

+ 라인(line) : 사다리의 가로 한 줄

```
|-----|     |-----|
```

+ 다리(bridge) : 라인의 한 부분 (다리가 존재하면 1, 다리가 존재하지 않으면 0)

```
|-----|
```

```
|     |
```

+ 보상(prize) : 사다리 실행 결과로 주어지는 보상

```
꽝    5000  꽝    3000
```

## 기능 구현 목록

### 참여자 등록 기능

- [x] 참여자 이름은 최대 5글자이다
- [x] 참여자 수는 최소 2명이다
- [x] 참여자 이름은 중복되지 않는다

### 사다리 생성 기능

- [x] 사다리 높이는 1이상이다
- [x] 사다리는 사다리 높이만큼의 라인을 가진다 (높이: 3 -> 라인: 3개)

### 다리 놓기 기능

- [x] 한 라인에서 다리가 겹치지 않게 랜덤으로 놓는다

### 사다리 실행 기능

- [x] 실행 결과 수는 참여자 수와 같다
- [x] 모든 참여자에 대한 사다리 실행 결과를 얻는다
- [x] 한 참여자에 대한 사다리 실행 결과를 얻는다
    - 게임에 등록된 참여자에 대해서만 결과를 얻을 수 있다

### 출력 기능

- [x] 사다리를 출력할 때 사람 이름도 같이 출력한다
    - 사다리 위에 왼쪽 정렬해 공백을 기준으로 구분해 출력한다
- [x] 사다리 폭은 가능한 참여자 이름의 최대 길이와 같게 출력한다
- [x] 사다리를 출력할 때 실행 결과(보상)도 같이 출력한다
    - 사다리 아래에 왼쪽 정렬해 공백을 기준으로 구분해 출력한다
- [x] 특정 대상에 대한 사다리 실행 결과를 출력한다
    - 대상은 참여자 개인일 수도 있고, 전체 참여자일 수도 있다

### 입력 기능

- [x] 참여자 이름은 쉼표(,)를 기준으로 구분해 입력한다
- [x] 실행 결과(보상)를 쉼표(,)를 기준으로 구분해 입력한다
- [x] 최대 사다리 높이는 숫자로 입력한다
- [x] 실행 결과를 보고 싶은 대상의 이름을 입력한다
    - 대상은 참여자 개인일 수도 있고, 전체 참여자일 수도 있다
    - 전체 참여자를 의미하는 all 이 입력될 때까지 여러 번 입력할 수 있다

# 부록

## Step1_고민한 포인트

( 피드백을 듣고 싶은 포인트는 ❓❓❓로 표시해뒀습니다. )

### primitive vs wrapper

- primitive
    - 장점)
        - stack 메모리에 저장되어 접근이 쉽고 빠르다.
        - 리터럴 값을 다루기 때문에(❓❓❓) 계산 속도가 빠르다.(+ 연산의 경우 literal 값을 사용하면 속도 더 빠름)
        - 값 변경이 가능하다.
    - 단점)
        - null 저장할 수 없다.
        - Collection, Generic 사용 시 wrapper로 변환해야 한다.
- wrapper
    - 장점)
        - null을 포함할 수 있다.(null이 들어갔을 때 예외를 던지지 않는다.)
        - 클래스 메서드를 사용할 수 있다.
    - 단점)
        - 한 번 더 감싸기 때문에 primitive 타입보다 성능이 느리다.
        - 저장된 값을 변경할 수 없고, 값을 변경하려면 새 인스턴스를 생성해야 한다.
        - 할당되는 메모리가 primitive 타입보다 크다.
        - 가독성이 좋지 않다.(특히 생성 로직)
- 우리가 생각한 결론)
    - not null인 상황에선 primitive를 사용하는 걸 default로 가져가고,
    - Collection이나 Generic 같은 문법을 사용해야 할 땐 wrapper 클래스로 변환해 사용하자.
    - 왜냐하면, wrapper는 메모리, 속도 측면에서 불리하기 때문이다.

### literal 이란 무엇일까?

- 정의) 프로그램에서 직접 표현한 값
- 종류) 정수, 실수, 문자, 논리, 문자열 리터럴
- 질문) 아래의 정의에 대한 반례는 없는가?
    - 원시타입은 정수, 실수, 문자, 논리 리터럴등의 실제 데이터 값을 '스택' 메모리에 그대로 저장하는 타입이다.
    - 참조타입은 객체의 메모리 주소값을 참조하는 타입이다.
    - 반례) String은 원시타입의 성격을 가지는 참조타입이다. (리터럴 저장하기도 함)
        - String은 literal과 new 키워드를 통해 생성하는 두 가지 방법이 존재한다.
        - literal로 생성하는 경우,
            - heap 영역의 String Constant Pool에 저장되기 때문에(불변이라 가능)
            - literal이 같다면 동일한 객체를 반환하여 메모리 낭비를 줄일 수 있다.
        - new 키워드로 생성하는 경우,
            - heap 영역에 저장되어 동일한 문자열의 값이라도 각각의 객체가 생성된다.

```
String a = "hi";
String b = "hi";
a == b // true
```

```
String a = new String("hi");
String b = new String("hi");
a == b // false
```

```
// 번외편) String이 final 클래스라고 해서, 아래 코드의 a가 불변객체인 건 아님. 선언문 앞의 final만 관련 있다.
String a = new String("hi"); // a는 불변아님
a = new String("hi"); // 가능
final String b = new String("hi"); // b는 불변임
b = new String("hi"); // 컴파일 오류
```

### model을 record로 표현해도 될까?

- record
    - 장점
        - 불변 객체를 쉽게 생성할 수 있게 해준다.
        - 기본적인 메서드(equals, hashcode, toString)를 내장하고 있어 가독성이 좋다.
    - 단점
        - final 클래스라서, 상속과 abstract 선언이 불가하다.
        - 필드값들이 final이라서, 필드값 수정이 불가하다.
        - 불필요한 기본 메서드(equals, hashcode, toString)가 자동 정의된다.
    - 특징
        - 필드의 종류가 두 가지다.
            - 상태 구성 요소 필드다.
            - 정적 필드
- 우리가 생각한 결론) 표현해도 된다
    - 통상적으론 dto에서 사용하지만, 모델에서 사용하지 않을 이유는 없다(❓❓❓)

```
record Rectangle(double length, double width) { // length는 상태 구성 요소 필드
    static double goldenRatio; // 정적 필드
```

[참고 문서](https://docs.oracle.com/en/java/javase/17/language/records.html)

[참고 문서](https://openjdk.org/jeps/359)

### Controller static 붙일까?

- 붙인다)
    - controller는 객체로 생성할 필요가 없고, 필드를 굳이 저장할 필요도 없어서 static 이어도 된다.
    - 메서드 호출 시간이 짧아지기 떄문에 효율이 좋다.
- 붙이지 않는다)
    - 전역적으로 사용하려는 목적이 있는 것이 아나다.
    - 자주 사용하지 않는 로직인데 GC의 관리 영역에서 배제되고, 메모리에 항상 상주하게 되는 것이 오히려 메모리 낭비가 된다.
    - static은 추상화, 형성과 같은 개념을 사용할 수 없어, 객체 지향의 패러다임과 상반된다.
- 우리가 생각한 결론)
    - 서비스 볼륨에 따라 다르다.
        - controller가 필드가 있는 경우(공유될 수 없는 경우)에는 static 키워드를 붙일 수 없다.
        - controller가 필드가 없는 경우(공유 되더라도 문제가 없는 경우)는 static을 붙여도 된다.

## Step2_고민한 포인트

- TDD를 따르다 마주한 고민: TDD가 점진적 설계라는 뜻을 이해해보자
    - 문제가 된 상황
        - 작은 단위라고 생각한 기능이 막상 구현하려 보니 굉장히 큰 단위였어서
        - 해당 기능을 구현하기 위해선 수많은 작은 단위의 내부 로직이 필요한 상황이 발생함
        - 난 이미 큰 단위의 기능에 대한 test fails를 작성해두었고,
        - test passes로 만들 차례였음
        - 이 경우, 큰 단위의 기능을 test passess 로 만들려면
        - 그 안의 수많은 작은 단위의 내부 로직은 test fails 단계를 거치지 않고 바로 만들어야 했음
        - 과연 이게 tdd를 올바르게 사용하고 있는 건지 의문이 듦
    - 내가 생각한 해결책
        - tdd를 사용할 때, 무엇부터 시작해야 할까?
            - 기능 목록을 보자마자 작은 단위가 떠올랐다면, 사실 곧바로 작은 단위의 기능부터 해도 문제는 없지만,
            - 규모가 큰 프로젝트로 갈 수록 작은 단위가 바로 떠오르지 않을 확률이 높다.
            - 그렇기에 tdd가 더 빛을 발하는 것인데,
            - 일단 우선순위가 높은 기능부터 작업해보자. 단위의 대소 유무를 생각하지 않고 말이다.
            - 그렇게 하다보면 그게 작은 단위 기능이라 쭉 어이서 작업하게 될 수도 있지만,
            - 나처럼 막상 구현하려보니 굉장히 큰 단위였을 수도 있다.
            - 아무 문제 없고, 오히려 좋다. 큰 단위였단 걸 깨달았단 건 작은 단위들을 드디어 구상(도출)해냈단 뜻이기 때문이다.
            - 아무것도 없던 상태에선 작은 단위들까지 전부 설계해내는 게 어려운 일이었지만,
            - 일단 단위의 크기를 상관 하지 않고, 중요한 작업부터 tdd로 작업하다보니 작은 단위에 무엇이 있는지 알게 되었다.
            - 이제, 큰 단위에 대해 짜둔 테스트는 무시한다 (아예 지워버려도 좋다)
            - 그리곤 알게 된 작은 단위에 대해 작업하면 된다
        - 이 과정에서 tdd가 점진적 설계라는 말을 체감할 수 있다
            - 처음부터 기능을 구현할 때 필요한 큰 단위부터 작은 단위까지 전부 설계해두고 시작할 필요가 없다
            - 일단 러프하게 어떤 기능들이 있는지 숙지하고, 중요해보이는 기능부터 작업을 시작한다
            - 작업하다보니 그 내부에 작은 단위들이 존재한단걸 인지했다면
            - 작업하던 건 큰 단위이므로 일단 버리고, 작은 단위부터 먼저 작업해주면 된다
            - 즉, 작업을 하면서 점전직으로 작은 단위들을 찾아나가는 것이다
            - 이것이 tdd를 점진적 설계라하는 이유다
    - 이번 미션에서 위에 적은 해결책을 실제로 적용해보았는가
        - 하려다가 필요 없어져서 못했다
        - 원랜 구현하던 기능보다 작은 기능 발견해서 아래와 같은 플로우를 가져가려 했다
            - test: 참여자들에 대한 사다리 실행 결과를 얻는다 <- 우선순위 높은 기능 구현
            - test: '참여자들에 대한 사다리 실행 결과를 얻는다' 없애기 <- 큰 기능이였어서 일단 테스트 제거
            - test: 참여자들은 인덱스를 가진다 <- tdd 통해 도출한 작은 기능 구현
            - feat: 참여자들은 인덱스를 가진다
            - test: 참여자들에 대한 사다리 실행 결과를 얻는다 <- 아까 하다 만 큰 기능 다시 구현
            - feat: 참여자들에 대한 사다리 실행 결과를 얻는다
        - 허나, 막상 또 구현하려보니 각 player가 인덱스를 가지고 이를 조작하는 것보단
        - 그냥 players의 인덱스를 받아와서 바깥에서 인덱스를 이용하는 게 더 낫겠단 판단이 섰다.
        - 이를 위해선 굳이 더 작은 기능으로 분화할 필요가 없어서
        - 원래 하던 `참여자들에 대한 사다리 실행 결과를 얻는다` 라는 기능을 이어 작업하기로 결정하였다
