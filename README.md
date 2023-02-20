# java-ladder

사다리 타기 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 기능 요구사항
### step1
1. 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다.
    1. 사다리를 출력할 때 사람 이름도 같이 출력한다.
2. 사람 이름은 쉼표(,)를 기준으로 구분한다.
3. 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
4. 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
5. |-----|-----| 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.

### step2
1. 사다리 실행 결과를 출력해야 한다.
2. 개인별 이름을 입력하면 개인별 결과를 출력하고, "all"을 입력하면 전체 참여자의 실행 결과를 출력한다.

## 기능 리스트

- 입력에서 처리해야하는 예외
    - [x] height -> 숫자만 가능하도록

- Name
    - 예외
        - [x] 이름은 최소 1자 이상, 최대 5글자
    - [x] 이름의 길이를 반환한다.

- Names
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

- domain.Results
  - 예외
    - [ ] 이름의 개수와 결과의 개수는 같아야한다.
  - [ ] 결과를 입력받아 split하여 Result를 담는 일급 컬렉션
  - [ ] 입력받은 순서대로 갖고 있어야 한다.
  
- Result
  - 예외
    - [x] 결과 값의 길이는 1이상 최대이름의 길이 이하

  