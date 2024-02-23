# java-ladder

사다리 타기 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

# 기능 요구사항
## 사다리 게임
- [x] 사다리 게임에 참여하는 사람은 여러명일 수도 있다.
- [x] 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 적절히 설정한다.
- [x] 사다리를 생성할 수 있다.
  - [x] 사다리의 라인 놓기는 랜덤 여부로 판단된다.


## 라인
- [x] (사람 수 - 1)만큼 라인을 놓을 수 있는 행을 생성할 수 있다.
- [x] 특정 사다리에서 라인을 둘 수 있다.
- [x] 다음 사다리에 라인을 둘 수 있는지의 여부를 확인한다.
- [x] 사다리의 한 행에 연속적으로 가로 라인이 겹치지 않는다.
- [x] `|-----|-----|` 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.

## 플레이어
- [x] 사다리 게임에 참여하는 사람은 이름을 갖고 있다.
- [x] 최대 5글자까지 부여할 수 있다.
- [x] 이름으로 공백을 허용하지 않는다.
- [x] 이름의 중복이 허용되지 않는다.

## 입출력
- [x] 입력한 사람이 0명일 경우, 재입력 받는다.
- [x] 사람 이름은 쉼표(,)를 기준으로 구분한다.
- [x] 사람 이름의 앞뒤 공백은 제거한다.
- [x] 사다리의 최종 결과를 출력한다.
- [x] 사다리를 출력할 때 사람 이름도 같이 출력한다.
- [x] 최대 사다리 높이를 입력받는다.
- [x] 입력값이 잘못되었을 경우, 사용자로부터 재입력받는다.
- [x] 에러 메세지를 구체적으로 작성한다.

## 사다리 높이
- [x] 입력값이 자연수임을 검증한다.

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

# step1 피드백
- [x] TDD 수행할 때 컴파일 되지 않는 상태를 커밋하지 않기
  - 다음 미션에 적용해보기!
- [ ] 테스트코드 indent 2 이상 넘지않게 수정하기
  - [ ] indent를 줄이기 힘들다면 `RandomBuildStrataegy`가 두가지 이상을 제어하고 있는게 아닌지 생각해보기
- [x] Boolean.TRUE -> primitive type으로 수정
- [x] `CanBuildStrategy` 클래스명 변경
  - 리뷰어님은 `LineBuildStrategy` 추천
- [x] `canBuildStrategey`의 `canBuildBridges()` 메소드명이 동어반복 느낌
  - `lineBuildStrategy.apply(int);`을 추천하심
- [ ] `RandomBuildStrategy`는 정말 random한 일만 하는가? 이 객체는 하나의 책임만 갖고 있는가? 인터페이스가 잘 설계되었나?
- [ ] `RandomBooleanGenerator`에서 static final로 선언한 값을 getGenerator로 가져오는 이유가 뭘까?
  - `new RandomBooleanGenerator` 로 사용하면 안되나?
  - 싱글톤으로 관리하기 위해서(계속해서 new로 객체를 생성하면 성능 저하가 발생할 수 있으니까) 사용한 것인데 진짜 싱글톤으로 관리된 것인지 확인
- [ ] Enum `BridgeSymbol`에서 getSymbol을 static으로 사용한 이유
  - 특정된 symbol 하나만 반환하는 것이 아니라 둘 중 하나의 symbol을 선택해서 반환해야 하기 때문에 사용함
- [ ] InputView 생성자 생략 가능
- [ ] InputView에서 try with resource를 학습하고 적용해보기
- [x] InputView의 `,` 상수화
  - [x] 이 외에도 다른 부분에 상수화 할 부분이 있는지 확인하기
- [ ] sout 대신 Line Separator 사용
- [ ] Height 클래스에서 정규식 패턴을 계속 비교하는 대신 
  - `private static final Pattern NUMBER_PATTERN = Pattern.compile("^[\\d]*$");`사용
- [ ] Ladder build 메소드의 파라미터명을 `isBridgesBuilt` -> `buildResults` 로 수정
- [ ] Line을 생성한 뒤 값을 넣지 않고 생성자에서 바로 값을 넣어주기
  - 적용시 Line의 validate와 RandomBuildStrategy 중복 로직 발생 해결가능.
  - 연속 true는 규칙 위반이라는 사실은 누가 알고 있어야 할까?
- [ ] Line의 point도 도메인 객체화 할 수 있다
- [ ] Player의 `NAME_MAX_LENGTH` -> `MAX_NAME_LENGTH`
- [ ] Players에서 정적 팩토리 메소드를 사용한 이유
