# java-ladder

사다리 타기 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 기능 구현 목록

- [x] 사다리 게임의 참여자가 있다.
    - [x] 참여자의 이름은 최대 5글자이다.
    - [x] 이름은 공백일 수 없다.
- [x] 사다리를 출력할 때 사람 이름도 같이 출력한다.
    - [x] 사람 이름을 출력할 때 모든 사람 이름이 같은 공간을 가지고 우측정렬한다.
- [x] 사람 이름을 쉼표(,)를 기준으로 입력받는다.
- [x] 사다리타기 동작하려면 라인이 겹치지 않도록 해야한다.
    - [x] **`|-----|-----|`**모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.
- [x] 랜덤으로 사다리를 생성하는 기능 추가.
- [ ] 사람에게 맞는 상을 계산하는 기능 추가.
- [ ] 사다리 게임 실행 결과를 출력한다.
    - [x] 출력할 때 사다리 폭도 넓게 설정한다.
    - [x] 사다리와 사람의 이름을 출력한다.
    - [ ] 결과를 보고 싶은 사람을 입력받으면 실행 결과를 출력한다.
        - [ ] 개인별 이름을 입력하면 개인별 상을 출력한다.
        - [ ] "all"을 입력하면 전체 참여자의 상을 출력한다.
    - [ ] 사다리 게임의 상들을 출력한다.
- [x] 사다리 높이를 입력받는다.
    - [x] 사다리 높이는 양수여야 한다.
    - [x] 사다리 높이는 정수(int 형)여야 한다.
- [ ] 사다리 게임의 상들을 입력받는다.
    - [ ] 상들은 쉼표를 기준으로 입력받는다.

## 예외 처리 목록

- [x] 입력된 사다리 높이가 0 이하인 경우 예외처리
- [x] 입력된 사다리 높이가 정수형이 아닌 경우 예외처리
- [x] 유저의 이름은 5자 초과인 경우 예외처리
- [x] 유저의 이름이 공백인 경우 예외처리
- [x] 유저의 이름으로 쉼표만 입력됬을 경우 예외처리
- [x] 유저의 이름에 아스키코드가 아닌 문자가 입력됬을 경우 예외처리(출력형식을 맞추기 위해)

## 다이어그램
