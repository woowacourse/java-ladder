# java-ladder

사다리 타기 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 기능 구현 목록

- [x] 사다리 게임의 참여자가 있다.
    - [x] 참여자의 이름은 최대 5글자이다.
    - [x] 이름은 공백일 수 없다.
    - (논의 사항) 참여자가 2인 이상이어야 한다.
- [x] 사다리를 출력할 때 사람 이름도 같이 출력한다.
    - [x] 사람 이름을 출력할 때 모든 사람 이름이 같은 공간을 가지고 우측정렬한다.
- [x] 사람 이름을 쉼표(,)를 기준으로 입력받는다.
- [x] 사다리타기 동작하려면 라인이 겹치지 않도록 해야한다.
    - [x] **`|-----|-----|`**모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.
- 랜덤으로 사다리를 생성하는 기능 추가.
- [x] 사다리 게임 실행 결과를 출력한다.
    - [x] 출력할 때 사다리 폭도 넓게 설정한다.
- [x] 사다리 높이를 입력받는다.
    - [x] 사다리 높이는 양수여야 한다.
    - [x] 사다리 높이는 정수여야 한다.
    - (논의 사항) 사다리 높이를 입력받을 때 0으로 시작하면 예외처리한다.
