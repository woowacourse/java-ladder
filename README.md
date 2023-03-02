# java-ladder

사다리 타기 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

--- 

## 1단계 기능 요구사항
- 참여자들
  - [x] 참여자는 이름을 갖는다.
  - [x] 이름은 중복될 수 없다.
  - [x] 참여자는 2명 이상이다.
  
- 참여자 이름
  - [x] 앞 뒤의 공백은 제거한다.
    - [x] 공백이 제거된 이름의 길이는 1이상 5이하이다.
  - [x] 이름에 한글이 들어갈 수 없다.

- 입력
  - [x] 참여자를 입력받을 때 쉼표(,)를 기준으로 이름을 구분한다.

- 사다리
  - [x] 사다리는 높이를 갖는다.
    - 높이
      - [x] 높이는 숫자(자연수)로 입력되어야 한다.
      - [x] 0보다 커야한다.
  - [x] 사다리는 높이만큼 선을 갖는다.

- 선
  - [x] True, False로 이루어진 Boolean List를 갖는다.
  - [x] 참여자의 개수보다 하나 적은 사이즈를 갖는다.
  - [x] 가로 라인이 겹칠 수 없다.

- 출력
  - [x] 실행 결과를 출력한다.
  - [x] 사람 이름은 6글자 기준으로 오른쪽 정렬로 출력한다.
  - [x] 사다리의 가로 길이는 5자로 출력한다.

---
## 1단계 미션 리팩토링
- 제어자
  - [x] 인텔리제이 설정 확인하기 (⌥⌘C → ⌥⌘C → private로 선택)
  - [x] Controller의 InputView OutputView는 외부에서 사용하는 필드가 아니므로 private final로 숨겨주기
  - [x] Line 클래스의 random 객체도 해당 클래스 내부에서만 사용되니 수정하기
  - [x] 키워드 정렬 순서 지키기
- 에러 출력 메세지의 위치 고민해보기
  - [x] 동료개발자가 "에러 메세지를 출력할 때 suffix 로 특수문자를 붙여주세요." 라는 요구사항을 접하면 `OutputView.java`와 `LadderGameController.java`중 어떤 파일을 먼저 열어볼까요? 에 대한 고민해보기
    - [x]  OutputView 클래스에 에러 메세지를 받아 출력하는 메서드 생성하기
    - [x]  LadderGameController 클래스에 있는 에러 메세지 outputview.printErrorMessage로 수정
  - [x] 마찬가지로 "사다리 높이에 대한 에러 출력 메세지 포맷을 변경해주세요." 라고 하면 어떤 파일을 먼저 열어볼까요? 에 대한 고민도 해보기
  - [x] LineSymbol Class 오류 메시지 출력하기
- 메서드 네이밍
  - [x] People class 의 사이즈 return 해주는 메소드 이름을 ‘크기’ 대신 ‘명’, ‘수’로 변경할 수 있도록 고민하기 .. getSize → getNumberOfPeople
  - [x] getNumberOfPeople → getPeople로 네이밍 수정 (Person의 복수형은 People로 많이 사용)
- stream
  - [x] OutputView의 printPeople 메소드 출력 방법을 for문 대신 stream 사용하기
  - [x] People class에서 List<Person> 생성하는 부분 stream 사용하기
- [x] 최종 생성자가 아래에 위치하도록 변경하기

---
## 2단계 기능 요구사항
- 사다리 결과
  - [x]  안내문구는 `실행 결과` → `사다리 결과` 로 변경한다.
  - [x]  하단에 입력 받은 실행 결과를 순서대로 출력한다.
- 실행 결과
  - [x]  입력 안내 문구를 출력한다.  `실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)`
  - [x]  앞 뒤의 공백은 제거한다.
  - [x]  공백이 제거된 실행 결과의 길이는 1이상 5이하이다.
  - [x]  쉼표(,)를 기준으로 실행 결과를 구분한다.
  - [x]  수는 참여자의 수와 같아야 한다.
  - [x]  사다리 결과 출력 하단부분에 순서대로 출력된다.
- 사다리 게임 실행 결과
  - [x] 완료 후 참여자 별 실행 결과를 저장해야 한다.
  - [x] 결과 안내 문구를 출력한다. `결과를 보고 싶은 사람은?` 
  - [x] 개인별 이름을 입력하면 개인별 결과를 출력한다.
    - [x] 실행 결과만 출력한다.
    - [x] 실행 결과 출력 후 다시 결과 안내 문구를 출력한다.
  - [x] "all"을 입력하면 전체 참여자의 실행 결과를 출력한다.
    - [x] 전체 참여자의 실행 결과를 `이름 : 결과` 형식으로 출력한다.
    - [x] 프로그램을 종료한다.
- 선
  - [x] 포인터 배열을 가진다.
  - [x] 개수는 참여자의 수와 같다.
- 포인터
  - [x] 아래, 좌, 우로 이동할 수 있다.
  - [x] 마지막 포인터에서는 오른쪽으로 이동할 수 없다.
  - [x] 첫번째 포인터에서는 왼쪽으로 이동할 수 없다.
- 결과
  - [x] 참여자와 해당 결과를 가진다.

---
## 2단계 미션 리팩토링
- 네이밍
  - [x] Persons class 네이밍 People로 변경
  - [x] 상수로 관리하던 에러 메세지 -> 직접 메세지를 보여주도록 수정
  - [x] getSize 메서드 size로 네이밍 변경 -> 일관성을 위해
  - [x] getter 범위나 네이밍 통일
- 함수(또는 메서드)
  - [x] indent(인덴트, 들여쓰기) depth를 2
  - [x] 상수와 객체의 필드 사이 개행 추가 
  - [x] 길이는 최대 10라인
- [x] 메소드 순서 정렬

---
## 2단계 미션 추가 리팩토링
- [x]  출력 결과를 판단하는 로직 `controller`에서 `view`로 변경하기
- [x]  Line class의 makeLine 메서드 분리하기
  - [x]  가장 왼쪽과 가장 오른쪽 Point 생성 하는 메소드 분리하기
- [ ]  Results class findResultOfPerson 메서드 key result 사용하기


- 네이밍
  - [x]  isResultType 메서드 네이밍 변경 → `printResultByType`
  - [x]  Ladder class의 size() 메서드 네이밍 변경
  - [x]  Line class의 `isPreRightPoint` 메서드 네이밍 변경 → `isPreRightConnect`
  - [x]  Line class의 `getRightIsBoolean`, `getLeftIsBoolean` 메서드 네이밍 변경 → `is~Connect`
  - [x]  Direction class의 `isDirection` 메서드 네이밍 변경 → `isConnect`
  - [x]  Ladder class의 필드명
  - [x]  Line class의 필드명
  - [x]  People class의 `MIN_PERSON_LENGTH` → `MIN_PEOPLE_COUNT`
- [ ]  테스트에 사용되는 공용 변수 `@BeforeEach`  사용하기
