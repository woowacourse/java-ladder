# java-ladder

사다리 타기 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)


---

## 💡프로젝트 개요
- 사다리 게임을 진행할 수 있는 프로젝트입니다.
---


## 📋 구현 기능 목록

## controller
- [x] 사다리 게임에 참여할 사람 이름을 입력받는다.
- [x] 최대 사다리 높이를 입력받는다.
- [x] 전체 플레이어 이름을 출력한다.
- [x] 사다리 생성 결과를 출력한다.

## model
- [x] 사다리 높이에 맞게 라인을 생성한다.

- [x] 사다리 라인이 연속적으로 겹치지 않도록 생성한다.
  - [x] 사다리 한 라인에 존재하는 포인트들을 만든다.
  - [x] 각 포인트들은 랜덤하게 만든다.
  - [x] 한 라인에서 같은 포인트가 연속으로 등장하지 않는다.

- [x] 사다리 게임 전체 참여자 정보를 생성한다.
  - [x] 사다리 게임 전체 참여자 명단을 반환한다.

- [x] 사다리 게임 참여자 정보를 저장한다.
  - [x] 참여자의 이름 정보를 조회할 수 있다.

- [x] 사람 이름은 최대 5글자까지 부여할 수 있다.
  - [x] 사람 이름은 문자로만 이루어져야 한다.

- [x] 참여자 이름은 쉼표를 기준으로 입력받는다.

- [x] 사다리 길이는 1이상의 자연수만 가능하다.


## view
### 입력
- [x] 게임 참여자 이름을 입력할 수 있다.
- [x] 최대 사다리 높이를 입력받는다.


### 출력
- [x] 사다리의 폭은 입력될 수 있는 사람 이름의 최대 길이로 고정한다. (상수화)
- [x] 출력 메세지
  - [x] 참여할 사람 이름 입력 메세지
  - [x] 최대 사다리 높이 입력 메세지
- [x] 실행 결과 출력
  - [x] 전체 플레이어 이름 출력
  - [x] 사다리 출력
    - [x] 사다리 발판 유/무에 따른 모양을 생성한다.


## Todo
- 매개변수 final화 하기
- (출력값을 위한 Enum 사용 고려?)
  - (true, 사다리 있는 칸 출력값)
  - (false, 사다리 없는 칸 출력값)
- 같은 클래스의 일급 컬렉션 비교 기능 추가하기
- toString 추가
- makeAllPlayerTest 테스트 결과 출력 부분
  - 테스트 케이스 추가
  - 혹은 parameterizedTest 어노테이션 삭제
- 플레이어 이름 제한 길이에 따른 step 길이 변화 기능 추가하기
