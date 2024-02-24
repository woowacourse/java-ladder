# java-ladder

사다리 타기 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

# 구현할 기능 목록

## 참여자들

- [x] 다음의 경우 IllegalArgumentException 을 발생시킨다.
  - 참여자 이름이 null이거나 공백인 경우
  - 참여자 이름의 길이가 5자 이상일 경우
  - 참여자들 이름이 중복된 경우

## LineState

- [x] 각 선들은 3가지 상태를 가진다.
  - START (연결선의 시작)
  - END (연결선의 끝)
  - NONE (아무것도 없음)

## Line

- [x] 참여자 인원 수와 `List<Boolean>`을 입력받아 `List<LineState>`를 생성한다.
- `List<LineState>` 생성 규칙은 아래와 같다.
  - [x] 0번째 인덱스는 이전 상태와 관련없이 1/2확률로 START 또는 NONE을 갖는다.
    - true일 경우 START
    - false일 경우 NONE
  - [x] 이전 상태가 END 또는 NONE일 경우 1/2확률로 START 또는 NONE을 갖는다.
    - true일 경우 START
    - false일 경우 NONE
  - [x] 이전 상태가 START이면 다음 상태는 END가 된다.

## 사다리

- [x] 사다리 높이와 참여자 인원 수, 난수 생성기를 입력받아 사다리 선을 추가한다.

## 난수 생성기

- [x] 횟수를 입력받아 그 크기만큼 `List<Boolean>`을 생성한다.
  - `new Random()`의 `nextBoolean()`으로 true/false 를 반환한다.

## 사다리 게임

- [x] 사다리 높이와, 참여자들, 랜덤 생성기로 사다리게임을 생성한다.
- [x] 사다리 높이가 다음의 경우 IllegalArgumentException을 발생시킨다.
  - 사다리 높이가 1보다 작을 경우

---

## 입출력

### 참여할 사람 이름을 입력받는다. (이름은 쉼표(,)로 구분한다)

- [x] 다음의 경우 IllegalArgumentException 예외를 발생시킨다.
    - null일 경우
    - blank일 경우
    - 구분자로 종료될 경우

### 최대 사다리 높이를 입력받는다.

- [x] 다음의 경우 IllegalArgumentException 예외를 발생시킨다.
    - NumberFormatException 이 발생한 경우

### 참여자들의 이름을 출력한다.

- [x] 참여자 이름의 길이가 4자 이하인 경우
  - 5칸을 기준으로 마지막 칸은 공백으로 둔다.
  - 나머지 4칸에 이름을 오른쪽으로 정렬시킨 뒤 나머지는 공백을 둔다.

- [x] 참여자 이름의 길이가 5자인 경우 변환없이 그대로 출력한다.
- [x] 각 참여자 이름은 공백으로 구분하여 출력한다.

```text
예시)
pobi   ash    ik  honux mason
```

### 사다리를 출력한다.

- [x] 사다리 막대(|)는 출력한 각 참여자의 5번째 아래에 생성된다.
- [x] Ladder 객체 상태에 따라 막대 사이를 다르게 이어준다.
  - LineState가 START 일 경우 `-----`로 이어준다.
  - 이외의 경우 5칸의 공백으로 이어준다.
  - 마지막 인덱스의 경우 이어주지 않는다.
