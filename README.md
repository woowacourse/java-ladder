# 🪜 사다리 타기 미션

## 구현할 기능 목록

### 입력 기능

- [x] 사람들의 이름을 입력 받을 수 있다.
- [x] 사람의 이름은 쉼표로 구분한다.
- [x] 사다리 높이를 입력 받을 수 있다.
- [x] 사다리 결과를 입력 받을 수 있다.
- [ ] 사다리 결과를 확인할 사람을 입력 받을 수 있다.

### 입력 검증

- [x] 사람의 이름은 1글자에서 최대 5글자까지 부여할 수 있다.
- [x] 사다리 결과는 1글자에서 최대 5글자까지 부여할 수 있다.
- [x] 사다리 높이는 0이거나 음수일 수 없다.
- [x] 사다리 높이는 숫자 값이어야 한다.
- [x] 사다리 타기 참여 인원수는 최소 2명이다.
- [x] 입력된 이름들은 중복되지 않는다.
- [ ] 사다리 결과 개수는 사다리 게임에 참여하는 사람 수와 같다.
- [ ] 사다리 결과를 확인할 사람의 이름이 게임에 존재해야 한다.

### 출력 기능

- [x] 만들어진 사다리를 출력할 수 있다
- [x] 사다리를 출력할 때 사람의 이름도 같이 출력한다
- [ ] 유저가 입력한 이름의 사다리 게임 실행 결과를 출력할 수 있다.

### 도메인 기능

- [x] 가로 줄 생성 로직
    - [x] 가로 연결은 연속으로 등장할 수 없다.
    - [x] 가로 줄은 랜덤한 값을 바탕으로 생성된다.
- [x] 가로 줄 로직
    - [x] 특정 위치에서 오른쪽으로 연결된 사다리가 있는 지 확인할 수 있다.
- [x] 랜덤 로직
    - [x] 2가지 연결 상태 중 무작위로 하나를 고를 수 있다.
- [x] 사다리
    - [x] 높이와 줄들의 정보를 추상화 한다.
    - [x] 사다리 특정 줄의 결과를 반환할 수 있다.
- [x] 사다리 생성 기능
    - [x] 높이, 인원 수, 생성 전략을 받아 사다리를 만든다.
- [x] 연결 상태
    - [x] 연결 상태는 연결된 것과 연결되지 않은 것 두가지 상태를 가진다.
