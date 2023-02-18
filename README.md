
# 기능 요구 사항


## 도메인
- [X] 사다리 게임에 참여하는 사람의 이름은 한 글자 이상 다섯 글자 이하이다.
  - [X] 이름이 다섯글자를 초과하거나 공백이면 예외를 던진다.
- [X] Users는 User 들로 이루어진 일급 컬렉션이다.
  - [X] 중복이름이 있으면 예외가 발생한다.
  - [X] List<User>의 size가 1이하일떄 예외가 발생한다.
- [X] 사다리의 높이는 1 이상이다.
- [X] 사다리의 너비는 User들의 수보다 1 적다.
- [X] 한 층은 Point들의 집합으로 이루어진다.
- [X] Point는 두 칸 사이를 이어주는 다리이다.
  - [X] Point의 필드 값이 true이면 생성된 다리이다.
    - [X] 생성된 다리일 경우 Point.FILLED, 미생성시 Point.EMPTY
  - [X] 한 층의 이웃한 Point는 연속해서 생성될 수 없다.
- [X] Ladder에서 NumberGenerator를 통해 다리 생성 결정 값 리스트를 만들어서 Floor에 전달한다.
  - [X] 전략 패턴을 이용해 TestNumberGenerator를 만들어서 테스트한다.

## 뷰 

### 입력
- [X] User 이름을 "," 기준으로 입력 받는다.
- [X] 사다리 층수를 입력받는다.
  - [X] 숫자만 입력 받을 수 있다.

### 출력
- [X] 이름과 사다리를 출력한다.


# 변경 요구 사항

- [X] README.md 업데이트
- [X] 컨벤션 정리
- [ ] given when then 스타일 테스트 작성
- [X] 방어적 복사 적용
- [X] 테스트 케이스 보강
- [X] name String 원시값 포장

# 추가 변경

- [X] 랜덤 생성을 nextInt에서 nextBoolean 으로 변경
- [X] Line 객체 역할을 Point enum이 대체
