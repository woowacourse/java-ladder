# 기능 명세

## View
- [x] 사다리 게임에 참여하는 사람의 이름을 입력 받는다.
  - [x] 사람의 이름은 5글자 이하여야 한다.
  - [x] 사람의 이름을 쉼표(,)로 구분해야 한다. (최소 2명 이상)
- [x] 사다리의 높이를 입력받는다.
  - [x] 사다리의 높이는 자연수여야 한다.
- [x] 사다리 모양과 사람이름을 출력해야 한다.
  - [x] 사람 이름은 5글자를 기준으로 출력한다.
- [x] 사다리 결과를 입력 받는다.
  - [x] 사다리 결과는 사람의 수 만큼 있어야 한다.
- [x] 결과를 보고 싶은 player 입력 받기
  - [x] 존재하는 player만 입력할 수 있다.
  
## Util
- [x] Boolean 값 랜덤 생성을 한다.

## Model
- [x] Peoples를 생성한다.
  - [x] People를 생성한다.
- [x] Lines를 생성한다.
  - [X] Line을 생성한다.
- [x] 현재 플레이어가 갈 수 있는 사다리인지 판단한다.
  - [x] player가 첫 번째 위치에 있을 때 0번째 point가 true면 무조건 right다.
  - [x] player가 마지막 위치에 있을 때 마지막 point가 true면 무조건 left다.
  - [x] // player가 첫 번째 위치 또는 마지막 위치가 아니라면 현재 위치의 point와 그 전 위치의 point를 계산한다.
- [x] 만약 player가 갈 수 있는 사다리라면 player의 position을 이동시킨다.
  - [x] player의 position을 Line의 isRightLadder 함수의 반환 값에 따라 이동시킨다.
[//]: # (- [ ] )