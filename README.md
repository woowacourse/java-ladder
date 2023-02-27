# java-ladder

사다리 타기 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 기능 구현 목록

### InputView
- [x] 이름 입력
- [x] 결과 입력
- [x] 사다리 높이 입력
- [x] 결과를 확인할 플레이어 이름 입력

### OutputView
- [x] 사다리 생성 결과 출력
  - [x] 플레이어를 사다리 위에 출력
  - [x] 사다리 출력
  - [x] 결과 출력
- [x] 한 명의 결과 출력
- [ ] 전체 결과 출력

### LadderController
- [x] 플레이어들 생성
- [x] 라인들 생성
- [x] 결과들 생성
- [x] 사다리 생성 결과 반환
- [ ] 플레이어 이름을 입력 받아 결과 계산 후 플레이어 반환
  - [x] 이미 계산된 상태이면 그냥 반환
  - [ ] 전체 결과 반환
    - [ ] 프로그램 종료


### Ladder
- [x] 입력 받은 사다리 사이즈만큼 라인 생성
- [x] 위치를 입력 받아 사다리 모양에 맞게 이동
- [x] 라인들을 반환

### Line
- [x] 라인 생성
  - [x] 연속되지 않게 Bar 생성
  - [x] Bar의 개수는 최소 1개 이상이어야 한다.
- [x] 현재 위치를 입력받아 다음 위치로 이동시키기

### Bar (Enum)
- [x] 이동 가능 여부를 나타내는 enum 객체 생성
- [x] 이동 가능 여부 반환

### Players
- [x] 여러 명의 플레이어 생성
  - [x] 이름은 쉼표(',') 기준으로 구분
  - [x] 플레이어는 2명 이상이어야 한다.
  - [x] 플레이어의 이름은 중복될 수 없다.
  - [x] 이름을 입력 받아 해당하는 플레이어 반환
- [x] 플레이어들의 이름 값 반환

### Player
- [x] 이름 텍스트를 입력 받아 플레이어 객체 생성
- [x] 결과 저장
- [x] 결과가 저장된 상태인지 여부 반환
- [x] 이름 텍스트 반환
- [x] 결과 반환
  - [x] 결과가 저장되지 않은 상태라면 예외 발생
- [x] 위치 반환
- [x] 입력받은 값과 이름이 같은지 여부 반환
- [x] 결과 내용 반환

### Name
- [x] 이름 텍스트를 입력 받아 이름 객체 생성
  - [x] 이름은 1글자 이상 5글자 이하여야 한다.
- [x] 입력받은 값과 같은 값을 지니는지 확인

### Results
- [x] 여러 개의 결과 생성
  - [x] 결과는 쉼표(',') 기준으로 구분
  - [x] 결과의 수는 플레이어의 수와 같아야 한다.
- [x] 결과들의 값 반환
- [x] 인덱스에 해당하는 결과 반환

### Result
- [x] 내용을 입력 받아 결과 객체 생성
- [x] 내용 반환

### Location
- [x] 초기 위치를 입력 받아 위치 객체 생성
  - [x] 초기 위치는 0 이상이어야 한다.
- [x] 이동 방향을 입력 받아 열 위치 이동
- [x] 열 위치 반환

### Direction (Enum)
- [x] 사다리 상에서 이동 방향을 나타내는 enum 객체 생성

### GameCommand (Enum)
- [x] 게임 반복 또는 종료를 나타내는 enum 객체 생성

