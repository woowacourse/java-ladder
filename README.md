# java-ladder

사다리 타기 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 기능 요구사항 해석

1. 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.
    - 사람의 이름은 중복이 되어선 안된다.
    - 이름은 최소 1글자 최대 5글자 까지 부여되어야 한다.
    - 알파뱃 대 소문자로 이루어 진다.
    - 사람 이름은 "all"일 수 없다.

2. 사람 이름은 쉼표(,)를 기준으로 구분한다.
    - 쉼표로 시작하거나 쉼표로 끝내면 예외 발생
    - 쉼표로 나뉘는데, 알파벳 대소문자가 아닌 경우 예외 발생
    - 사람은 최대 10명까지 받을 수 있다.

3. 사다리 높이를 입력할 수 있다.
    - 사다리 높이는 5 이상 10 이하의 정수로 입력해야 한다.
    - 사다리의 폭은 사람들의 수이다.

4. 실행 결과를 입력할 수 있다. 실행 결과란, 사다리 게임에서 사다리 아래의 항목을 말한다.
    - 실행 결과는 쉼표(,)를 기준으로 구분한다.
    - 각 실행 결과는 최소 1글자 최대 5글자 까지 부여되어야 한다.
    - 각 실행 결과는 공백 문자만으로 이루어질 수 없다.

5. 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
    - 사다리의 가로(`-`)는 `최대 이름 길이`로 고정한다.
    - 사람의 이름은 사다리의 세로(`|`) 에 맞춰 정렬한다.
    - 사람의 이름이 `최대 이름 길이`보다 작을경우 다음과 같은 규칙으로 공백을 추가한다.

          ```
          `a`     -> `   a `
          `aa`    -> `  aa `
          `aaa`   -> ` aaa `
          `aaaa`  -> `aaaa `
          `aaaaa` -> `aaaaa`
          ``` 

6. 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
    - |-----|-----| 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.
7. 사용자 입력 중 예외가 발생할 경우, 예외 발생 원인을 출력한 뒤, 처음부터 다시 입력받는다.
8. 사다리 게임 실행 결과를 알 수 있다.
    - all 을 입력한 경우 전체 결과를 알 수 있다.
    - 앞서 입력한 사람 이름 중 하나를 입력하면 그 사람의 결과를 알 수 있다.
    - 잘못된 입력을 할 경우, 예외 메세지를 출력한 뒤 결과를 보고 싶은 사람 이름부터 다시 입력받는다.

## 기능 목록

- [x] 사람 이름 입력 기능
    - [x] 사람 이름 길이 검증 기능
    - [x] 사람 이름 문자 검증 가능
- [x] 사람 생성 기능
    - [x] 사람 이름 중복 검증 기능
    - [x] ","로 구분된 사람 이름 입력 기능
    - [x] 사람 이름 개수 검증 기능
- [x] 사다리 높이 입력 기능
    - [x] 사다리 높이 검증 기능
- [x] 사다리 생성 기능
    - [x] 사다리 높이 지정 기능
    - [x] 사다리 전체 폭 지정 기능
    - [x] 세로 라인 생성 기능
    - [x] 가로 라인 생성 기능
- [x] 사람 이름, 사다리 출력 기능
    - [x] 사람 이름 출력 기능
    - [x] 사다리 출력 기능
- [x] 입력 예외 처리 기능
- [x] 실행 결과 입력 기능
- [x] 실행 결과 판독 기능
- [x] 실행 결과를 보고 싶은 이름 입력 기능
- [x] 실행 결과 출력 기능

## 1단계 피드백 반영 사항

- [x] Pattern 객체 재사용하도록 수정
- [x] 도메인 로직에서 UI 로직 분리
    - [x] ~ String 클래스 이름 변경
    - [x] ~ String 클래스 view 패키지로 이동
    - [x] 이름 관련 정책 구현 위치 view로 이동
