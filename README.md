# java-ladder

사다리 타기 미션 저장소

## 기능 목록

### 입력
- [x] 참여한 사람 이름 입력
  - [x] 최대 5자
  - [x] ','로 구분하여 입력
- [x] 사다리 높이 입력
    - [x] 1 이상

### 출력
- [x] 실행결과
  - [x] 사람 이름이 5자 미만이어도 출력 형식에 맞춰 공백 출력
  - [x] 첫 번째 사다리의 경우, 첫 번째로 입력한 사용자 이름의 길이에 맞게 공백 출력

### 게임
- [x] 선 생성
  - [x] 난수를 통해 판단
  - [x] 라인 생성
    - [x] 사다리 높이만큼 생성
    - [x] True를 연속으로 가질 수 없다.

### 테스트
- [x] domain
   - [x] User
     - [x] 이름은 5자 이하이다.
     - [x] 이름은 1자 이상이다.
     - [x] 이름은 공백이 포함될 수 없다.
     - [x] 이름은 빈 문자열일 수 없다.
   - [x] Ladder
     - [x] 선이 연속될 수 없다.
     - [x] 사다리의 높이는 1 이상이어야 한다.

### 리팩터링
- [x] enum 사용
- [x] 메소드 분리
- [x] 원시 값, 문자열 포장
- [x] indent 1
- [x] 메소드 10 라인 이내로 작성

**1단계 리뷰에 따른 리팩터링**
- [x] 불필요한 Wrapping Class 제거
- [x] public으로 선언되어 있지만, 외부에서 사용하지 않는 메소드 접근제어자 private으로 변경
- [x] `Name.validateNameLength()` 메소드 분리
- [x] 현재 상수 final로 선언 -> static final로 수정
- [x] `@ParameterizedTest` 활용한 테스트 작성
- [x] 잘못된 입력 받으면 종료하지 않고, 올바른 값을 입력할 때까지 재입력

---
## 2단계
- [x] 사다리 게임 결과
    - [x] 입력한 유저의 수만큼 결과를 입력한다.
      - [x] 쉼표로 구분하여 입력
- [x] 사다리 실행 결과 출력
  - [x] 한 명의 유저가 하나의 당첨 결과를 갖게 된다.
  - [x] 사다리의 최하단에 결과 목록 출력
  - [x] 이름을 입력하여 해당 유저의 결과를 확인할 수 있다.
    - [x] "all" 입력 시, 모든 유저의 결과 확인
      - [x] 입력한 순서대로 출력
      - [x] 결과 출력 후 게임 종료
    - [x] [예외처리] 게임을 진행하지 않은 이름 입력 시 예외

### 리팩터링
- [x] 예외 메세지 정의
- [x] 사용자 이름 "all"인 경우 예외 발생
- [x] 사다리 타기 과정에서 발생할 수 있는 예외 생각하기
- [x] 테스트 작성
- [x] 메소드 라인 확인
- [x] indent 확인

**1단계 리뷰에 따른 리팩터링**
- [x] 메서드 선언 위치를 사용 순서에 맞게 재배치한다.
- [x] 컨벤션에 따른 상수 선언 final static -> static final
  - 참고 : https://stackoverflow.com/questions/11219556/difference-between-final-static-and-static-final
- [x] GameResults 클래스명 변경
- [x] position 클래스로 포장
- [x] view - domain 의존성 제거

**Position 클래스**
- 사용자의 위치를 나타냄
- [x] 이동
  - [x] 오른쪽 이동
  - [x] 왼쪽 이동
- [x] [예외처리] 불가능한 위치
  - [x] 0보다 작을 때
  - [x] `사용자의 수 - 1` 보다 클 때

---
### 궁금한 내용
1. List<GameResult>를 감싸고 있는 일급 컬렉션인 GameResults를 생성할 때, 어떤 것이 더 좋은 방법일까?
  - 생성자에 InputView에서 받은 List<String>을 넣어주고 내부 메소드에서 GameResult를 생성하여 List<GameResult>에 add 하는 방법
  - 컨트롤러에서 InputView에서 받은 List<String>을 List<GameResult>로 만들어준 뒤, 생성자에 List<GameResult>를 바로 넣어주는 방법
2. 테스트 메소드 역시 카멜 케이스/스네이크 케이스로 네이밍하며 일관성을 지켜야 될까?
3. 메서드 위치 컨벤션
  - public을 다 놓은 다음, 순서에 맞게 private 배치??
  - public 놓으면서, 안에서 사용하는 private 메소드 바로 아래에 배치??
4. DTO는 어느 패키지에서 관리해야 할까?
5. UsersNameDto 클래스가 List<Name>을 매개변수로 받고, 이를 List<String>으로 변환하여 인스턴스 변수로 저장하는 로직을 가지고 있어도 될까?
6. DTO 생성자의 매개변수로 도메인 객체 자체를 넘겨주는 것이 좋을지, 아니면 필요한 필드를 직접 꺼내서 넘겨주는 것이 좋을지?
7. Boolean을 Point가 감싸고, List<Point>를 Line이 감싸고, List<Line>을 Lines가 감싸고, List<Lines>를 Ladder가 감싸는 현재 상황에서 DTO를 어떻게 만드는 게 좋을까?
8. 인터페이스로 구현체를 숨기며 view에 전달하는 것은 mvc 패턴의 `view와 Domain은 서로 의존하지 않는다`에 어긋나지 않는 것일까?
---
    
## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)
