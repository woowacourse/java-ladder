# java-ladder

사다리 타기 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)


## 기능 정의

- Name
  - [x] name의 길이가 5글자 이하임을 검증할 수 있다
  - [x] name의 길이가 공백임을 검증할 수 있다
  - [x] 자신의 이름을 답할 수 있다
- Names
  - [x] names 안에서 중복이 있는지를 검증할 수 있다
  - [x] names에서 최소 2명 이상의 참가자가 있음을 검증할 수 있다
  - [x] Name 객체를 하나의 컬렉션에서 중복 없이 관리한다
- Block
  - [x] 한 Line의 첫 번째 Block을 생성할 수 있다
  - [x] 마지막 Block이 등장하기 전까지의 중간 Block을 생성할 수 있다
  - [x] 마지막 Block을 생성할 수 있다
- Line
  - [x] 최소 참여 인원을 검증할 수 있다
  - [x] 참여자 수와, 이동 경로 생성 전략을 받아 한 줄의 Line을 생성한다
- Ladder
  - [x] 사다리의 최소 높이를 검증할 수 있다
  - [x] 사다리 높이와, 참여자 이름, 이동 경로 생성 전략을 받아 전체 사다리를 생성한다
- strategy
  - [x] 다음 사다리로 이동하는 경로를 생성한다
- 예외처리
  - [x] 사다리의 높이는 1이상이어야 한다
  - [x] 구분자가 포함되어야 한다
