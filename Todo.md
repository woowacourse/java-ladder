## Todo
- 위치 객체 구현
- LadderRow에서 getBridges의 bridge와 인스턴스 변수 bridges의 bridge 사이 차이가 있도록 이름을 다시 짓는다.
- Ladder 에서 row, column 확인 (범위 안에 있는지)
- 사다리에서 그릴 수 있는 수 이상의 다리를 그리려고 할 때 예외 처리.
- LadderNavigator에서 row, column의 의미가 두 가지 이상이다. -> 두 의미를 구분할 클래스를 만든다.
- results 입력 예외
    - 빈 입력, 6글자 이상, player 수를 초과하는 입력


## Done
- 사다리의 가로선 설계 및 구현
- N개의 다리를 그림.
    - N개의 다리가 실제로 그려졌는지 확인.
- XXXTest 및 outputview 리네이밍
- outputview 리팩토링
- 이름으로 입력받아서 결과(이름)을 출력
- 게임이 돌아가도록 구현
- 사용자들 입력 예외
    - null, 빈 입력 예외처리
- round 입력 예외
    - 1 이상 정수 입력이 아닌 입력