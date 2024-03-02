# java-ladder

사다리 타기 미션 저장소

## 구현 기능 목록

- [x] 참여할 사람 이름을 입력받는다.
  - [x] 쉼표(,)를 기준으로 구분한다.
  - [x] 앞뒤 공백은 제거한다.
  - [x] 참여자 이름을 최소 1글자는 부여해야 한다. `예외`
  - [x] 참여자 이름을 최대 5글자까지 부여할 수 있다. `예외`
  - [x] 참여자 이름으로 'all'은 사용할 수 없다. `예외`
  - [x] 참여자가 두 명 이상이어야 한다. `예외`
  - [x] 참여자 이름이 서로 달라야 한다. `예외`
- [x] 실행 결과를 입력받는다.
  - [x] 쉼표(,)를 기준으로 구분한다.
  - [x] 앞뒤 공백은 제거한다.
  - [x] 결과는 1글자 이상이어야 한다. `예외`
  - [x] 결과는 5글자 이하여야 한다. `예외`
  - [x] 결과 수가 참여자 수와 같아야 한다. `예외`
- [x] 최대 사다리 높이를 입력받는다.
  - [x] 문자열을 정수로 변환한다.
  - [x] 높이가 1 이상이어야 한다. `예외`
- [x] 결과를 보고 싶은 사람(타겟)을 입력받는다.
- [x] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
  
<br>

**사다리 생성**
- [x] 입력받은 최대 사다리 높이만큼 라인을 생성한다.
- [x] 입력받은 참여자 수만큼 좌표를 생성한다. 
  - 좌표에는 `왼쪽`, `오른쪽`, `아래` 방향이 있다.
  - 시작 좌표는 `왼쪽` 방향일 수 없다.
  - 끝 좌표는 `오른쪽` 방향일 수 없다.
  - `오른쪽` 방향과 `왼쪽` 방향은 연달아 나와야 한다.
  - 모든 방향이 `아래` 방향이면 안 된다.

**사다리 게임 실행**
- [x] 특정 참가자의 사다리를 실행한다.
  - 이미 실행 결과가 존재한다면 다시 계산하지 않는다. 
  - 타겟이 참여자여야 한다. `예외`
  - 타겟의 위치를 찾는다.
  - 타겟의 위치에서 각 라인마다 좌표의 방향에 따라 이동한다.
  - 최종 이동 위치의 결과가 참여자의 실행 결과이다.
- [x] 모든 참가자의 사다리를 실행한다.
  - 모든 참가자에 대해 특정 참가자의 사다리 실행을 반복한다.
- [x] 모든 참가자의 실행 결과를 제공했다면 사다리 게임을 종료한다.

<br>

- [x] 사다리를 출력할 때 사람 이름과 결과 항목도 같이 출력한다.
- [x] 사람 이름과 결과 항목은 5자 기준으로 출력한다.
  - [x] 글자 수에 따라 `***a*`, `**aa*`, `*aaa*`, `aaaa*`, `aaaaa`와 같이 공백(*)을 추가한다.
  - [x] 구분을 위해 뒤에 공백(*)을 추가한다.
- [x] 사람 이름과 결과 항목이 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
- [x] 사다리 실행 결과를 출력한다.
  - [x] 특정 참여자의 실행 결과이면 결과 항목만 출력한다.
  - [x] 모든 참여자의 실행 결과이면 사람 이름과 결과 항목을 출력한다.

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)
