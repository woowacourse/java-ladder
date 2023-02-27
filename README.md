# java-ladder

사다리 타기 미션 저장소

## 이번 미션의 목표

- [ ] SRP
- [ ] 모든 변수명에 final 붙이기 (당연히 메서드 파라미터에도 final을 붙인다.)
- [ ] 모든 원시값과 문자열을 포장한다.
- [ ] 일급 컬렉션을 쓴다.

## 기능 요구 사항

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
- [x] OutputView
    - [x] 사다리를 출력할 때 사람 이름도 같이 출력한다.
    - [x] 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다

## 요구 사항 분석 후  페어와 추가한 검증 사항

- [x] 이름은 최소 2개를 받는다
- [x] 높이는 최소 1 이상이다.

## 2단계에서 추가된 요구 사항

- [ ] 사다리 실행 결과를 출력해야 한다.
- [ ] 개인별 이름을 입력하면 개인별 결과를 출력한다
- [ ] "all"을 입력하면 전체 참여자의 실행 결과를 출력한다.

## 요구 사항 분석 후 추가한 요구 사항

- [ ] "end" 입력 시, 프로그램이 종료된다.

## 객체 설계

- [x] Name
    -[x] 이름의 길이 검증
    -[x] 최대 5글자
    -[x] 이름의 길이 반환

- [x] Position
    - [x] 원시값 int 포장
    - [x] 위치 값을 검증한다.

- [x] Player
    - [x] Name과 Position을 멤버로 가진다
    - [x] Position 객체를 주면 이동한다.

- [x] Players
    - [x] Player의 수가 2명 이상인지 검증
    - [x] Player 인스턴스 생성
    - [x] 이름이 가장 긴 선수의 이름 길이 리턴
    - [x] 첫번째 Player의 이름 길이 리턴
    - [x] Player의 수와 순서 관리

- [x] Link
    - [x] 원시값 boolean 포장

- [x] Layer : Link의 일급 컬렉션
    - [x] 선의 연결 상태가 최소 하나 이상인지 검증
    - [x] 연결된 Link가 중복해서 존재하는 지 검증

- [x] Height
    - [x] 원시값 int 포장
    - [x] 높이가 최소 1 이상인지 검증

- [x] Ladder
    - [x] Line과 Height를 멤버로 가진다.
    - [x] Line 인스턴스 생성

- [x] LadderGame
    - [x] 사다리 게임을 실행한다.
    - [x] 결과를 리턴한다.

- [x] WinningPrize
    - [x] 게임의 상품을 저장
    - [x] 상품 문자열이 빈칸인지 검증

- [x] WinningPrizes
    - [x] 입력받은 상품 객체를 저장하는 일급 컬렉션

- [x] GameResult
  - [x] 최종 결과 순으로 나열된 List<Player>를 가진다.
  - [x] winningPrizes 객체를 가진다.
  - [x] 우승자의 이름이 입력되면 해당 winningPrize를 리턴한다.

- [x] LinkGenerator
    - [x] RandomLinkGenerator를 위한 인터페이스

- [x] RandomLinkGenerator
    - [x] 랜덤으로 Link 생성

- [x] InputView
    - [x] 사람 이름 입력
        - 쉼표(,)를 기준으로 구분
    - [x] 게임 상품 입력
        - 쉼표(,)를 기준으로 구분
    - [x] 사다리 높이 입력
        - 정수값만 리턴
    - [x] 결과를 보고 싶은 사람의 이름을 입력받는다.

- [x] OutputView
    - [x] 사다리를 출력할 때 사람 이름도 같이 출력한다.
    - [x] 가장 긴 이름의 길이를 기준으로 사다리 폭이 변화한다.
    - [x] 첫번째 Player 이름 길이의 절반을 반올림 값한만큼 공백을 생성한다.
    - [x] 입력받은 사람의 이름을 winningPrize를 출력한다.

- [x] LadderElement
    - [x] 사다리의 요소들을 모아둔 Enum
