# java-ladder

사다리 타기 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

# 기능 요구사항
## 사다리 게임
- [ ] 사다리 게임에 참여하는 사람은 여러명일 수도 있다.
- [ ] 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 적절히 설정한다.
- [x] 사다리를 생성할 수 있다.
  - [ ] 사다리의 라인 놓기는 랜덤 여부로 판단된다. 


## 라인
- [x] (사람 수 - 1)만큼 라인을 놓을 수 있는 행을 생성할 수 있다.
- [ ] 특정 사다리에서 라인을 둘 수 있다.
  - [ ] 마지막 라인에서는 라인을 둘 수 없다.
- [ ] 다음 사다리에 라인을 둘 수 있는지의 여부를 확인한다.
- [ ] 사다리의 한 행에 연속적으로 가로 라인이 겹치지 않는다.
- [ ] `|-----|-----|` 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.

## 플레이어
- [x] 사다리 게임에 참여하는 사람은 이름을 갖고 있다.
- [x] 최대 5글자까지 부여할 수 있다.
- [x] 이름으로 공백을 허용하지 않는다.
- [x] 이름의 중복이 허용되지 않는다.

## 입출력
- [ ] 입력한 사람이 0명일 경우, 재입력 받는다.
- [x] 사람 이름은 쉼표(,)를 기준으로 구분한다.
- [ ] 사람 이름의 앞뒤 공백은 제거한다.
 - [ ] 사다리의 최종 결과를 출력한다.
- [ ] 사다리를 출력할 때 사람 이름도 같이 출력한다.
- [x] 최대 사다리 높이를 입력받는다.
- [ ] 입력값이 잘못되었을 경우, 사용자로부터 재입력받는다.

## 사다리 높이
- [ ] 입력값이 자연수임을 검증한다.

# 프로그래밍 요구사항
- indent(인덴트, 들여쓰기) depth를 1까지만 허용한다.
- 3항 연산자를 쓰지 않는다.
- else 예약어를 쓰지 않는다.
- switch/case도 허용하지 않는다.
- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다
- UI(System.out, System.in) 로직은 제외
- 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.
- 배열 대신 컬렉션을 사용한다.
- Java Enum을 적용한다.
- 모든 원시 값과 문자열을 포장한다
- 줄여 쓰지 않는다(축약 금지).
- 일급 컬렉션을 쓴다.

# Git commit 메세지
접두어로 `docs`, `test`, `feat`, `fix`, `refactor`, `chore` 사용
example feat: 사용자 입력 후 도메인 사용