# java-ladder

사다리 타기 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

--- 

## 기능 요구사항
- 참여자들
  - [x] 참여자는 이름을 갖는다.
  - [x] 이름은 중복될 수 없다.
  - [x] 참여자는 2명 이상이다.
  
- 참여자 이름
  - [x] 앞 뒤의 공백은 제거한다.
    - [x] 공백이 제거된 이름의 길이는 1이상 5이하이다.
  - [x] 이름에 한글이 들어갈 수 없다.

- 실행 결과
  - [ ] 실행결과는 각 결과를 갖는다
  - [ ] 결과는 중복될 수 있다
  - [ ] 실행결과의 개수는 참여자의 명수와 같아야 한다

- 입력
  - [x] 참여자를 입력받을 때 쉼표(,)를 기준으로 이름을 구분한다.
  - [ ] 실행결과를 입력받을 때 쉼표(,)를 기준으로 각 결과를 구분한다.
  - [x] 사다리의 높이를 입력 받을 떄 정수를 입력 받는다

- 사다리
  - [x] 사다리는 높이를 갖는다.
    - 높이
      - [x] 높이는 숫자(자연수)로 입력되어야 한다.
      - [x] 0보다 커야한다.
  - [x] 사다리는 높이만큼 선을 갖는다.

- 선
  - [x] True, False로 이루어진 Boolean List를 갖는다.
  - [x] 참여자의 개수보다 하나 적은 사이즈를 갖는다.
  - [x] 가로 라인이 겹쳐서는 안된다. / 겹칠 수 없다.

- 출력
  - [x] 실행 결과를 출력한다.
  - [x] 사람 이름은 6글자 기준으로 오른쪽 정렬로 출력한다.
  - [x] 사다리의 가로 길이는 5자로 출력한다.
