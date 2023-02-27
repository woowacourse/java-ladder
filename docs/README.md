## 🚀 사다리 타기

---
- [x] 사람 이름
  - [x] 입력받기 LadderGameController#requestPlayerName
  - [x] ,(쉼표)로 구분
  - [x] 검증
    - [x] 1글자 이상 5글자 이하 Person#validate
    - [x] 중복 불가 Persons#validate

- [x] 실행 결과 
  - [x] 입력받기 LadderGameController#requestLadderResult
  - [x] ,(쉼표)로 구분
  - [x] 검증
    - [x] 입력받은 사람 이름 수와 같아야 함 LadderGameController#validatePrizeCount

- [x] 사다리 높이
  - [x] 입력받기 LadderGameController#requestLadderHeight
  - [x] 검증
    - [x] 정수 Height#validateIntegerNumber
    - [x] 2이상 100이하 Height#validateNumberRange

- [x] 사다리 생성
  - [x] 입력 받은 높이의 사다리 생성 Ladder
  - [x] 사다리 칸 수는 (사람수 - 1) Line
  - [x] 다리가 두 칸 이상 연속되게 생기면 안된다 Line#hasBridgeInLeftOrRight
  - [x] 각 칸마다 다리 생성 여부는 랜덤값으로 결정 RandomBridgeGenerator

- [x] 사다리 게임 실행
  - [x] 시작 위치는 입력 순서대로 Persons#initializePerson
  - [x] 칸 이동
    - [x] 연결된 다리가 있는지 확인
    - [x] 있으면 옆 칸으로 이동
  - [x] 라인 이동
  - [x] 게임 결과 매칭
    - [x] 해당 위치에 있는 사람 이름 반환
    - [x] 이름과 결과를 매칭

- [x] 사다리 결과 출력
  - [x] 사다리 폭 : "가장 이름이 긴 사람" 의 이름 크기로 고정
  - [x] 사람 이름 오른쪽 정렬
  - [x] 실행 결과 왼쪽 정렬

- [x] 실행 결과 출력
  - [x] 결과 보고 싶은 사람 입력
    - [x] 개인별 이름을 입력하면 개인별 결과를 출력
    - [x] "all"을 입력하면 전체 참여자의 결과를 출력
    - [x] 참가하지 않은 사람의 이름 입력 불가


- [x] 예외 발생 시 재입력
