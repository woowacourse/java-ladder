# java-ladder

사다리 타기 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 기능 요구사항

### 입력
- 참가자들의 이름 입력
  - [x] "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)"을 출력한다.
  - [x] 참여할 사람의 이름입력 받고 ,로 구분한다.
- 실행 결과 입력
  - [x] "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)" 을 출력한다.
  - [x]  실행 결과를 입력받는다.
- 사다리 높이 입력
  - [x] "최대 사다리 높이는 몇 개인가요?" 을 출력한다.
  - [x]  최대 사다리의 높이를 입력 받는다.


### 참가자
- 참가자의 이름
  - [x] 참가자의 이름은 최대 5글자까지 부여할 수 있다.
  - [x] 참가자의 이름은 `null` 이거나 공백일 수 없다.

### 참가자들
- 참가자들
  - [x] 중복된 참가자들은 존재할 수 없다.
  - [x] 참가자의 수는 한명 이상이어야 한다.
  - [x] 참가자들의 시작 위치를 알 수 있다.

### 높이
- 높이
  - [x] 최대 사다리의 높이는 양수가 되어야 합니다

### 사다리
- 사다리
  - [x] 사다리의 행의 개수는 최대 사다리의 높이의 개수와 같다.
  - [x] 사다리의 행 내부의 라인을 생성할 수 있다
  - [x] 사다리의 결과를 알 수 있다.

- 사다리의 행
  - [x] 행 내부의 라인이 겹치지 않도록 생성할 수 있다.
  - [x] 사다리의 행 내에서 라인에 따라 이동할 수 있다.

- 사다리 행의 한칸
  - [x] 값에 따라 한칸이 실선인지 아닌지 판단할 수 있다. 

### 사다리 생성 전략
- [x] 주어진 갯수만큼 랜덤한 형태의 값으로 생성할 수 있다

### 사다리 결과
- [x] 사다리의 결과는 `null` 이거나 공백일 수 없다.

### 사다리 결과 모음
- [x] 위치에 따라 결과를 알 수 있다.
- [x] 참가자의 수와 결과의 개수가 같지 않을 시 예외가 발생한다.

### 사다리 게임 참가자 결과
- [x] 사용자 별로 사다리 결과를 저장할 수 있다
- [x] 존재하지 않는 참가자의 결과를 알려고 한다면 예외가 발생한다.

### 위치
- [x] 위치를 저장할 수 있다.
- [x] 위치를 미리 저장하여 캐싱의 효과를 얻을 수 있다.

### 사다리 게임
- [x] 참가자들의 결과를 알 수 있다.


### 출력
- 참가자 이름 출력
  - [x] 참가자의 이름을 5자 기준으로 출력한다.
- 사다리 출력
  - [x] 랜덤하게 생성된 사다리를 출력한다.
- 결과 출력
  - [x] 실행결과를 출력한다.
- 사다리 결과 출력
  - [x] 참가자들의 결과를 출력할 수 있다.


### 예시
실행 결과
위 요구사항에 따라 4명의 사람을 위한 5개 높이 사다리를 만들 경우, 프로그램을 실행한 결과는 다음과 같다.
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
