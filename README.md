# java-lines

사다리 타기 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

### 기능 목록

- [x] 사람 이름 입력
    - [x] 사람의 수는 2명 이상 100명 이하 `PersonNumber`
    - [x] 사람의 이름은 1글자 이상 5글자 이하 `Name`
    - [x] 빈 문자열(공백) 입력시 예외처리

- [x] 최대 사다리 높이 입력
    - 사다리 높이는 1 이상 100 이하 `Height`

- [x] 사람 이름 출력
- [x] 사다리 만들기
- [x] 사다리 출력

### 추가 기능 목록

- [x] 이름 앞뒤 공백 제거

### 페어 피드백 요구사항 정리

- [x] `Line` 객체가 `personCount`와 어떻게 연관되어 있는지 와닿도록 변수명 고민하기
- [ ] `Line` 객체가 어떤걸 의미하는지 알 수 있도록 이름 고민하기
- [x] 파일 마지막 및 가독성을 위한 개행 추가하기
- [x] 프로그래밍 요구사항 적용하기 (인덴트 depth를 2를 넘지 않도록 구현)
- [x] 가독성 높이기 (괄호 중첩 등)
- [x] `InputView`의 `parseInt`에서 발생할 수 있는 예외 처리하기
- [ ] 자바 패키지 고민하기 (booleanGenerator)
    - 네이밍은 적절한가?
    - utils 도메인 하위에 있어야 하는가?
    - 해당 패키지의 클래스들은 범용적인가?
- [x] `LadderSizeValidator`의 `validateIntRange` 로직 확인하기
- [x] 접근 제어자 확인하기
- [x] format에 해당하는 변수에는 `_FORMAT`을 달아 명확히 하기
- [ ] 결과 출력 개행 알아보기
- [x] `Lines`에서 `RandomBooleanGenerator` 생성 책임 분리하기
- [ ] 변수명을 통해 예측할 수 있도록 수정하기
- [x] 매직넘버 상수화하기
- [x] 메서드 및 생성자 순서 지키기
- [x] `@DisplayName` 적용하기 및 메시지 용어 통일하기
- [x] `Controller`에서 View 관리와 게임 상태 관리 책임 분리하기

### 피드백 요구사항 정리

- [ ] 사람의  숫자와 사다리 중간에 연결될 수 있는 가로선의 개수의 차이가 1이라는 것을 사다리를 잘 아는 클래스에서 관리하기
- [ ] `Names` 클래스의 `validate` 먼저 수행하기
  - 이름의 개수가 2개 미만이거나 100개 초과일 경우 불필요한 코드가 실행되므로
- [ ] `LineTest`의 연속된 `true`값을 테스트하기 위해 `TrueBooleanGenerator` 클래스 사용하기
- [ ] 메서드명 컨벤션 지키기 (카멜케이스)
- [ ] 예외 메시지 검증 추가하기
- [ ] `LinesTest` 테스트 수정하기
- [ ] `NamesTest` 100명 초과 테스트 추가하기
