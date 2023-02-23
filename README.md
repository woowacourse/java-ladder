# java-ladder

사다리 타기 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://githubcom/woowacourse/woowacourse-docs/blob/master/maincourse/READMEmd)

## 뷰

- [ ] 입력
    - [x] 사람 이름을 입력 받는다
        - [x] 안내 문구를 출력한다
        - [x] ','로 구분된다
        - [x] 빈값은 허용되지 않는다
        - [x] 입력값의 공백을 제거한다
    - [x] 높이를 입력 받는다
        - [x] 높이를 요구한다
        - [x] 양의 정수만 허용된다
        - [x] 빈값은 허용되지 않는다
    - [ ] 실행 결과를 입력 받는다
        - [ ] 안내 문구를 출력한다
        - [ ] ','로 구분된다
        - [ ] 빈값은 허용되지 않는다
        - [ ] 입력값의 공백을 제거한다
    - [ ] 결과를 보고 싶은 사람의 이름을 입력 받는다
        - [ ] 안내 문구를 출력한다
        - [ ] 한명의 이름 혹은 all을 입력 받는다
- [ ] 출력
    - [ ] 사다리 결과를 출력한다
        - [x] 사다리 결과 문구를 출력한다
        - [x] 이름들을 출력한다
        - [x] 사다리를 출력한다
        - [x] 사다리의 폭은 사람 이름의 최대길이에 따른다
    - [ ] 결과를 보고 싶은 사람의 결과를 출력한다
        - [ ] 이름과 결과를 출력한다
        - [ ] 이름과 결과 사이에 " : "를 넣는다

## 비지니스 로직

- [x] 사다리
    - [x] 사다리는 층들을 갖는다
- [x] 층
    - [x] 사람 총 수보다 한개 적은 다리를 갖는다
    - [x] 다리는 랜덤으로 연결된다
    - [x] 다리는 연속해서 연결되지 않는다
- [x] 이름
    - [x] 이름의 길이는 1 ~ 5 글자이다
- [x] 높이
    - [x] 높이는 1 ~ 5000 사이의 정수만 가능하다
- [x] 사람 수
    - [x] 사람 수는 1 ~ 100명 사이이다
- [ ] 결과
    - 결과의 길이는 1 ~ 5 글자이다
    - 결과의 수는 사람의 수와 일치해야한다.
- [ ] 사디리 게임
    - [ ] 사다리를 따라가서 결과를 찾는다
    - [ ] 사디리의 결과에 따라서 실행 결과를 찾는다 