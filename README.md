# java-ladder

사다리 타기 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

---

## 기능 목록

- [x]  참여할 사람의 이름을 입력 받는다
    - [x]  쉼표(,)로 구분한다
    - [x]  최대 5글자 까지 부여할 수 있다
    - [x]  이름에 공백에 포함되면 공백을 삭제한다
    - [x]  참여하는 사람 수가 2명 미만이면 예외처리 한다
    - [x]  중복된 이름이 들어오면 예외처리 한다
- [x]  사다리 높이를 입력 받는다
    - [x]  정수가 아닌 입력이 들어오면 예외처리한다
    - [x]  사다리 높이가 2 미만이면 예외처리한다
- [x]  사다리를 생성한다
    - [x]  세로라인을 사람 수 만큼 생성한다
    - [x]  가로라인을 생성한다
        - [x]  일정한 확률(50%)로 가로라인 생성 여부를 결정한다
        - [x]  결정된 생성 여부에 따라 가로 라인을 생성한다
        - [x]  만약 가로 라인이 겹친다면 그 줄은 넘어간다
- [x]  결과를 출력한다

---

## 2단계 추가 기능 목록

- [ ]  참여자 별 사다리 결과 저장
- [ ]  사다리에 따라 참여자와 결과 매칭: 사다리 타기
- [ ]  실행 결과 출력
    - [ ]  반복해서 출력 가능 하도록
- [ ]  에러 메세지 출력
- [ ]  입력 값 제한
    - [ ]  글자 수 제한
    - [ ]  숫자 최대 범위 제한
        - [ ]  참가자 수: 사다리 모양을 유지할 수 있는 선에서 최대값
        - [ ]  사다리 높이: 100
    - [ ]  참여자 이름 all 불가능하게 제한
    - [ ]  참여자 이름 quit 불가능하게 제한?