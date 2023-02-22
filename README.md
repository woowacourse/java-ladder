# java-ladder

사다리 타기 미션 저장소

## 이번 미션의 목표
- [x] SRP
- [x] 모든 변수명에 final 붙이기 (당연히 메서드 파라미터에도 final을 붙인다.)
- [x] 모든 원시값과 문자열을 포장한다.
- [x] 일급 컬렉션을 쓴다.

## 기능 요구 사항
- [x] 플레이어
  - [x] 이름과 위치를 가지고 있어야 한다.
  - [x] 좌로 움직여야 한다.
  - [x] 우로 움직여야 한다.
- [x] 이름
    - [x] 최소1글자, 최대5글자
    - [x] 쉼표(,)를 기준으로 구분
    - [x] 이름 길이도 반환해준다.
- [x] 선
    - [x] 라인이 겹치지 않도록 해야 한다.
    - [x] 최소 1층 이상
- [x] InputView
    - [x] 사람 이름 입력
    - [x] 사다리 높이 입력
    - [ ] 사다리 결과를 입력 받는다.
    - [ ] 사다리 결과를 출력할 방식을 입력 받는다.
- [x] OutputView
    - [x] 사다리를 출력할 때 사람 이름도 같이 출력한다.
    - [x] 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다
    - [ ] 사다리 결과와 사람이름을 같이 출력해야한다.
      - [ ] 전체 출력 기능
      - [ ] 이름을 입력하면 해당하는 이름을 가진 사람 출력
- [x] 사다리 게임 관련 기능
  - [x] 시작 위치가 주어지면 결과가 나온다.

## 요구 사항 분석 후  페어와 추가한 검증 사항
- [x] 이름은 최소 2개를 받는다
- [x] 높이는 최소 1 이상이다.

## 객체 설계
- [x] Name
  - [x] 최대 5글자
  - [x] 공백 여부 검증
  - [x] 이름의 길이 검증
  - [x] 이름 길이도 반환해준다.
- [x] Names: List<Name>
  - [x] 이름의 갯수가 2개 이상인지 검증
  - [x] Name 인스턴스 생성
  - [x] 가장 긴 이름의 길이 리턴
  - [x] 첫번째 이름 길이 절반의 반올림된 값 리턴
  - [x] 참가 인원 수와 순서 관리
- [x] Line :List <Boolean>
  - [x] 선의 연결 상태가 최소 하나 이상인지 검증
  - [x] 라인이 겹치지 않도록 생성한다.
- [x] Ladder : List<Line>
  - [x] 높이의 수가 하나 이상인지 검증
  - [x] Line 인스턴스 생성
- [x] PickStrategy
  - [x] Boolean Picker를 위한 인터페이스
- [x] RandomBooleanPicker
  - [x] 랜덤으로 boolean 값을 생성
- [x] InputView
  - [x] 사람 이름 입력
    - [x] 쉼표(,)를 기준으로 구분
  - [x] 사다리 높이 입력
    - [x] 정수값만 리턴한다.
- [x] OutputView
  - [x] 사다리를 출력할 때 사람 이름도 같이 출력한다.
  - [x] 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다
 → 저희는 동적으로 움직이는 것이라 해석했습니다.
 정답은? 클라이언트에게 다시 여쭤본다. (임의 해석은 하지 않는다.)
