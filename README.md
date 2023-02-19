# java-ladder

사다리 타기 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 리팩터링 목록

- [x] 테스트 리팩터링
  - [x] LineTest DisplayName 및 메서드명, ParameterizedTest
  - [x] LineGeneratorTest BridgeGenerator 변수로, 변수명 수정
- [x] 참가자들 일급 컬렉션
- [x] 참가자 이름이 같으면 같은 참가자로 취급
- [x] 참가자 표현을 Person 에서 Participant로 변경
- [x] 예외 핸들러에서 예외 출력을 OutputView로 위임
- [x] 사다리 표현 방식을 View로 옮긴다.
- [x] `Bridge == EXIST` 대신 doesExist() 메서드 사용
- [x] LadderEngine::makeLines 인자 간략화(참가자 수만 전달)

## 기능 목록

### 참가자

- [x] 이름은 최소 1글자 이상 최대 5글자 이하여야한다.
- [x] 참가자 이름이 같으면 같은 참가자로 취급한다

### 참가자들

- [x] 2명 이상이어야 한다
- [x] 중복될 수 없다

### Ladder

- [x] 높이는 양수만 가능하다.

### BridgeGenerator

- [x] 브릿지 하나를 생성한다
    - [x] RandomBridgeGenerator는 랜덤으로 브릿지 하나를 생성한다.

### LineGenerator

- [x] 라인 하나를 생성한다
- [x] 한 라인은 최대 (사람 수 - 1)개의 브릿지를 가진다
- [x] 브릿지가 연속되지 않게 생성한다.

### Bridge

- [x] 주어지는 브릿지와 연속인지 알 수 있다.
- [x] 출력 문자를 알 수 있다.

### Input

- [x] 사람 이름은 "," 로 구분한다.
- [x] 사람 이름은 중복될 수 없다.
- [x] 사람은 2명 이상이어야 한다.
- [x] 최대 사다리 높이를 입력받는다.

### Output

- [x] 사다리를 출력한다.
    - [x] 참가자 이름을 출력한다.
    - [x] 브릿지들을 출력한다.

### 예외 처리

- [x] 잘못된 입력부터 다시 받는다