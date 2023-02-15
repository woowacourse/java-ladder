# java-ladder

사다리 타기 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## ✨기능 구현 목록

- [x] 참여자 이름 입력받기
    - [x] 사람이름은 공백 제외 1글자 이상, 5글자 이하
    - [x] 쉼표로 구분한다
    - [x] 사람이름 중복입력 불가


- [x] 사다리 높이 입력받기
    - [x] 0이상 10이하의 정수만 입력 가능


- [x] 사람이름과 높이에 따라 사다리생성

- [x] 생성한 사다리 출력
    - [x] 사람이름 출력시, 이름이 5자 이하면 공백을 붙여서 5글자로 만듬
    - [x] 사다리를 지정된 형식으로 parsing 하여 출력

## 🎉 Refactoring list

- [x] 에러메세지 enum을 통한 상수화
- [x] 매직넘버 상수화
- [x] 변수명 정리
- [x] 메서드명 정리
- [x] 입력값 예외발생 시, 메세지 출력후 재입력
- [x] 입력된 이름 공백제거
- [x] LadderRow 생성자에서 validate
    - [x] 연속적으로 true가 들어오면 예외발생
