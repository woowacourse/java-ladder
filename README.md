# java-ladder

사다리 타기 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)


---
## 📚 도메인 모델 네이밍 사전

| 한글명 | 영문명          | 설명                   |
|-----|--------------|----------------------|
| 참가자 | Participants | 사다리 게임에 참가하는 사람들을 지칭 |
| 사람  | Person       | 사람을 지칭               |
| 사다리 | Ladder       | 사다리 지칭               |
| 라인  | Line         | 사다리의 한줄을 지칭          |
| 결과  | Result       | 실행 결과를 지칭            |

<br>

## 👨‍🍳 기능 목록

- 참가자
    - [x] 사람은 10명까지 ( 테스트 원할한 범위 )
    - [x] 사람은 2명 이상이다.
    - [x] 사람이름은 ',' 로 구분한다.
    - [x] 중복된 이름을 가질 수 없다.


- 사람
    - [x] 이름은 최대 5글자까지 가능하다
    - [x] 이름은 빈문자 혹은 공백으로만 이루어지면 안 된다


- 사다리 게임
    - [x] 사다리를 생성한다.
    - [x] 사다리 게임의 결과를 판단한다.
    - [x] 보고싶은 사람의 사다리 게임의 결과를 전달한다.


- 사다리
    - [x] 사다리의 높이는 숫자여야 한다.
    - [x] 사다리의 최소 높이는 1이다.
    - [x] 사다리의 최대 높이는 10이다. ( 테스트 원할한 범위 )
    - [x] 사다리는 높이만큼의 라인을 가진다.
    - [x] 사다리의 라인은 1이상 9이하의 갯수의 상태를 갖는다. (참가자수에서 1을 뺀 값)


- 라인
    - [x] 라인은 1이상 9이하의 갯수의 상태를 갖는다.
    - [x] 상태는 두 가지 경우를 가진다 (연결 혹은 비연결)
        - [x] true, false 중 랜덤한 boolean을 생성한다.
        - [x] 연속으로 연결상태를 가질 수 없다.


- 참가자
    - [x] 사람은 10명까지 ( 테스트 원할한 범위 )
    - [x] 사람은 2명 이상이다.
    - [x] 사람이름은 ',' 로 구분한다.
    - [x] 중복된 이름을 가질 수 없다.


- 결과들
    - [x] 결과는 사람 수 만큼이다.
    - [x] 결과는은 ',' 로 구분한다.크
    - [x] all을 받은 경우 전체 결과를 반환한다.
    - [x] 사람 이름을 받은 경우 해당 사람의 결과를 반환한다.


- 결과
    - [x] 사다리의 결과는 최대 5글자까지 가능하다
    - [x] 결과는 빈문자 혹은 공백으로만 이루어지면 안 된다


- 출력
    - [x] 사람 이름은 5자 기준으로 출력하기에 폭도 이에 맞춘다.
    - [x] 보고 싶은 사람의 실행 결과를 출력한다.


- 입력
    - [x] 참여자 이름을 입력한다.
    - [x] 최대 사다리 높이를 입력한다.
    - [x] 실행 결과를 입력한다.
    - [x] 결과를 보고 싶은 사람의 이름을 입력한다.

## 요구 사항

- [x] 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다.
- [x] 사다리를 출력할 때 사람 이름도 같이 출력한다.
- [x] 사람 이름은 쉼표(,)를 기준으로 구분한다.
- [x] 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
- [x] 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
    - [x] |-----|-----| 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.
      <br>
- [x] 실행 결과를 쉼표(,)를 기준으로 구분한다.
- [x] 사다리 결과 출력 시 결과도 함께 출력한다.
- [x] 결과를 보고 싶은 사람 이름을 입력한다. (all 입력 시 전체 결과 출력)
- [x] all이 아닐 경우 결과 보고 싶은 사람 이름을 다시 물어야 한다.

## 📌 Commit Convention

커밋 메시지는 다음과 같은 형태로 작성합니다.

```Bash
> "커밋의 타입: 커밋 메세지 내용"
ex) "docs: 기능 목록 추가"
```

커밋의 타입은 아래 10가지 중 가장 적절한 것을 선택해 작성합니다.

| 커밋의 타입 |                       설명                        |
| :---------: | :-----------------------------------------------: |
|    feat     |                 새로운 기능 추가                  |
|     fix     |                     버그 수정                     |
|   comment   |             필요한 주석 추가 및 변경              |
|    test     |                 테스트 코드 추가                  |
|    docs     |      문서를 추가 혹은 수정 (ex. README 수정)      |
|   rename    |     파일 혹은 폴더명을 수정하거나 옮기는 작업     |
|   remove    |            파일을 삭제하는 작업만 수행            |
|    chore    |    빌드 태스크 업데이트, 패키지 매니저를 설정     |
|  refactor   |                   코드 리팩토링                   |
|    style    | 코드 포맷팅, 세미콜론 누락, 코드 변경이 없는 경우 |

<br>

## 📌 Code Convention

- 구글 Java 코딩 컨벤션을 준수합니다.
- IntelliJ의 Formatter를 적용합니다.
