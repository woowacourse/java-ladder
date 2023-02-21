# java-ladder

사다리 타기 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 기능 리스트

- 입력에서 처리해야하는 예외
  - [x] height -> 숫자만 가능하도록

- Player(PlayerName)
  - 예외
    - [x] 이름은 최소 1자 이상, 최대 5글자
  - [x] 이름의 길이를 반환한다.

- Players
  - 예외
    - [x] 참여 가능 플레이어 수는 2명 이상, 10명 이하이다.
    - [x] 참여 플레이어의 이름 중 중복된 이름이 있으면 안된다.
  - [x] 플레이어들의 이름 중 가장 긴 이름의 길이를 반환해준다.
  - [x] 플레이어 만드는 기능
  - [x] 참여한 플레이어의 숫자를 반환한다.
  - [x] 첫번째 플레이어의 이름, 이름 길이를 반환한다.

- Ladder(Height, Lines)
  - Height, Line을 관리한다. (확장성)

- Height(int height)
  - 예외
    - [x] 높이는 1 이상 10 이하이다.
  - [x] 높이는 입력을 받은 만큼 생성된다.

- Line (높이당 1개씩)
  - [x] 발판 만드는 기능

- LadderSymbol
  - [x] 기호를 반복 횟수만큼 반환하는 기능

- LadderResult
  - 예외
    - [ ] 입력 값이 공백이면 안된다.
  - [ ] 사다리 게임의 결과를 반환하는 기능

- LadderResults
  - 예외
    - [ ] 결과의 수는 사람의 수와 같아야한다.
