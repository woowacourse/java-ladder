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
- [x] 사다리 게임 참여할 사람 이름 입력
- [ ] 실행 결과 입력
- [x] 최대 사다리 높이 입력
- [x] 사다리 결과 출력
- [ ] 결과 보고 싶은 사람 입력
- [ ] 실행 결과를 출력

## model
- [x] 사다리 라인이 연속적으로 겹치지 않도록 생성

- [x] 사다리 게임 참여자 정보를 저장

- [x] 사람 이름은 최대 5글자까지 부여 가능
  - [x] 사람 이름은 문자로만 구성

- [x] 사다리 길이는 1이상의 자연수만 가능.

- [ ] 실행 결과 정보 저장
  - [ ] 실행 결과 검증

- [ ] 사다리 결과 계산 

- [ ] 참여자별 결과 정보 저장


## view
### 입력
- [x] 게임 참여자 이름 입력
  - [x] 참여자 이름은 쉼표를 기준으로 입력
- [x] 최대 사다리 높이를 입력
- [ ] 실행 결과 입력
- [ ] 결과 보고 싶은 사용자 입력

### 출력
- [x] 사다리의 폭은 입력될 수 있는 사람 이름의 최대 길이로 고정한다. (상수화)
- [x] 출력 메세지
  - [x] 참여할 사람 이름 입력 메세지 출력
  - [x] 최대 사다리 높이 입력 메세지 출력
  - [ ] 실행 결과 입력 메세지 출력
  - [ ] 결과 보고 싶은 사람 입력 메세지 출력

- [x] 사다리 결과 출력
  - [x] 참가자 이름 출력
  - [x] 사다리 출력
  - [ ] 실행 결과(꽝 / 돈) 사다리 하단에 출력

- [ ] 결과 보고 싶은 사용자 실행 결과 출력
  - [ ] all을 입력하면 전체 참여자의 실행 결과 출력
