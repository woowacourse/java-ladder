# java-ladder

## input
- 참가자
    - 참자가 이름 최대 5글자 제한
    - 참가자 쉼표로 구분(splitor : ,)
    - 공백 제거
    - 1명 이상

- 사다리 높이 입력 받기
    - 1 이상 입력 받기

## row
- boolean 값을 담을 List
    - true / false (가로선 여부)를 만들어줄 메서드
    - 연속적으로 true가 나올 수 없음
    - row의 인덱스와 참가자의 position을 비교해서 좌우 이동 결정

## member
- 현재 위치를 표시하는 position
- move (row의 index, true / false)

## Members
- List<Member>의 일급컬렉션

## Result
- 사다리 게임 진행 결과를 담음

## LadderGame
- 사다리 게임을 진행하기 위한 변수와 메서드를 가지고 있음
- members / result / ladder

## output
- 사다리 게임 내용 및 결과 출력 담당