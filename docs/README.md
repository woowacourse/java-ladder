## 🚀 사다리 타기

---
- [x] 사람 이름
    - [x] 입력받기 LadderGameController#requestPlayerName
    - [x] ,(쉼표) 로 구분
    - [x] 1글자 이상 5글자 이하 Person#validate
    - [x] 중복 불가 Persons#validate

- [x] 사다리 높이
    - [x] 입력받기 LadderGameController#requestLadderHeight
    - [x] 정수만 LadderGameController#validateNumber
    - [x] 2이상 Height#validate

- [x] 사다리 생성
    - [x] 입력 받은 높이의 사다리 생성 Ladder
    - [x] 사다리 칸 수는 (사람수 - 1) Line
    - [x] 가로 라인이 겹치면 안된다 Line#hasBridgeInLeftOrRight
    - [x] 각 칸마다 사다리 생성 여부는 랜덤값으로 결정 RandomBridgeGenerator

- [x] 실행결과 출력
    - [x] 사다리 폭 : "가장 이름이 긴 사람" 의 이름 크기로 고정
    - [x] 사람 이름 오른쪽 정렬

- [x] 예외 발생 시 재입력