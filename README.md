# java-ladder

사다리 타기 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

# 기능 요구사항 목록
- [X] : 사람 이름을 입력 받는다.
    - [X] : 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다.
    - [X] : 사람 이름은 쉼표(,)를 기준으로 구분한다.
    - [X] : 사람은 최소 2명 이상 입력받아야 한다.
    - [X] `예외처리` : 빈 값을 입력받는 경우
- [X] : 실행 결과를 입력 받는다.
    - [X] : 실행 결과는 최대 5글자까지 부여할 수 있다.
    - [X] : 실행 결과는 쉼표(,)를 기준으로 구분한다.
    - [X] : 실행 결과는 최소 2개 이상 입력받아야 한다.
    - [X] : `예외처리` : 빈 값을 입력받는 경우
- [X] : 사다리 높이를 입력 받는다.
    - [X] `예외처리` : 빈 값을 입력받는 경우
    - [X] `예외처리` : 숫자가 아닌 경우
    - [X] `예외처리` : 0 이하인 경우
- [X] : 사다리를 출력한다.
    - [X] : 사다리를 출력할 때 사람 이름도 같이 출력한다.
    - [X] : 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
    - [X] : 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
- [X] : 사다리 게임 결과를 출력한다.
    - [X] : 개인별 이름을 입력하면 개인별 결과를 출력한다.
    - [X] : "all"을 입력하면 전체 참여자의 실행 결과를 입력한다.
