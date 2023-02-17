# java-ladder

사다리 타기 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 기능 목록

### Person

- [x] 사람 이름은 최소 1글자 이상 최대 5글자 이하여야한다.

### Ladder

- [x] 사람들을 가진다
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