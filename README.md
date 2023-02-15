# java-ladder

사다리 타기 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 프로그램 실행 프로세스

1. 게임에 참여할 사람 이름 입력메세지 출력 -> 게임에 참여할 사람 이름 입력
2. 최대 사다리 높이 입력메세지 출력 -> 최대 사다리 높이 입력
3. 사다리 생성<br>
   3-1. (사람 수-1) 만큼의 칸을 가진 가로 라인 생성<br>
   3-2. 최대 사다리 높이 만큼 '3-1' 반복하여 세로 라인 생성
4. 실행 결과 출력

## 기능 목록

---

### 도메인 기능 목록

- [x] 게임에 참여할 사용자
  - [x] validation: 이름의 길이는 최대 5글자까지 가능
  - [x] validation: 이름의 중복 검사
- [x] 사다리 높이
- [ ] 사다리
  - [ ] 사다리 생성
  - [ ] (사람 수-1) 칸을 가지는 가로 라인 생성
    - [ ] 랜덤하게 칸을 연결하거나 하지않음
    - [ ] 이웃한 칸이 연결되어있으면 해당 칸과는 연속으로 연결되지 않음
  - [ ] 사다리 높이만큼 세로 라인 반복 생성

### 뷰 기능 목록

- 입력
  - [x] 게임에 참여할 사람 이름 입력
    - [x] validation: 공백 입력이 아닌지 검증
  - [x] 최대 사다리 높이 입력
    - [x] validation: 자연수인지 검증

- 출력
  - [x] 게임에 참여할 사람 이름 입력 안내메시지 출력
  - [x] 최대 사다리 높이 입력 안내메시지 출력
  - [ ] 생성된 사다리 출력