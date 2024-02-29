# 기능 목록

### Game

#### LadderGame
- [x] 게임에 사용될 자원을 가진다.
- [x] 게임 시스템을 확인하고 실행하는 시스템을 가진다.
- [x] 게임 결과를 가진다.
- [x] 게임에 필요한 자원을 등록한다.
- [x] 사다리 게임 실행 시스템을 통해 게임을 실행시킨다.
- [x] 게임 결과를 반환한다.

#### GameResource
- [x] 게임에 사용될 플레이어를 가진다.
- [x] 게임에 사용될 사다리를 가진다.
- [x] 게임에 사용될 상품을 가진다.
- [x] 각 자원을 추가한다.
  - [x] 추가할 자원이 null일 경우 예외를 발생시킨다.
  - [x] 이미 추가된 자원이 있는 경우 예외를 발생시킨다.
- [x] 각 자원의 크기를 반환한다.

#### GameExecutor
- [x] 게임 시작 전 게임에 필요환 환경을 검증한다.
  - [x] 자원이 없을 경우 예외를 발생시킨다.
  - [x] 자원의 크기(플레이어 수, 사다리 시작점 수, 상품 수)가 동일하지 않은 경우 예외를 발생시킨다.
- [x] 게임 로직을 실행한다.
  1. 플레이어마다 작업을 반복한다.
    - 플레이어의 순서는 등록된 순서이다.
  2. 각 플레이어의 시작 위치는 플레이어의 순서에 따른 라인의 순서와 동일하다.
  3. 플레이어의 현재 위치(라인)의 방향을 확인한다.
  4. 방향에 따라 다음 라인의 움직인 방향으로 현재 위치값을 변경한다.
  5. 사다리의 맨 아래 부분까지 이동한 경우 해당 위치에 있는 상품이 당첨된다.
  6. 플레이어의 당첨된 상품을 결과에 저장한다.

#### GameResult
- [x] 사다리게임의 결과를 가진다.
  - [x] 게임 결과는 사용자별로 존재한다.
  - [x] 게임 결과는 사용자와 당첨품으로 구성된다.
- [x] 특정 사용자의 게임 결과를 저장할 수 있다.
  - [x] 저장하려는 사용자가 없을 경우 예외를 발생시킨다.
  - [x] 저장하려는 당첨품이 없을 경우 예외를 발생시킨다.
  - [x] 이미 저장된 당첨품을 저장하려는 경우 예외를 발생시킨다.
- [x] 특정 사용자의 결과를 반환할 수 있다.
  - [x] 사용자를 찾을 수 없을 경우 예외를 발생시킨다.
- [x] 저장된 모든 결과를 반환할 수 있다.
  - [x] 저장된 결과가 없을 경우 예외를 발생시킨다.

### Resource

#### User
- [x] 사다리 게임에 참여하는 사람에 이름을 부여할 수 있다.
    - [x] 이름의 길이가 1~5자가 아닐 경우 예외를 발생시킨다.
    - [x] 이름이 영문 대소문자가 아닌 경우 예외를 발생시킨다.
    - [x] 이름 내에 공백이 존재할 경우 예외를 발생시킨다.

#### Users
-  [x] 사다리 게임의 사용자들을 가진다.
  - [x] 사용자 수가 2~10 범위 내에 있지 않을 경우 예외를 발생시킨다.
  - [x] 중복된 사용자의 이름이 있을 경우 예외를 발생시킨다.

#### Ladder
- [x] 사다리는 각각의 라인으로 이루어져 있다.
- [x] 사다리의 라인 수는 사다리의 높이를 나타낸다.
  - [x] 사다리의 높이가 1~50 범위 내에 있지 않을 경우 예외를 발생시킨다.

#### Line
- [x] 사다리의 가로줄에 해당하는 라인이다.
- [x] 라인의 각 지점에는 다음 위치로 움직여야 하는 방향이 있다.
- [x] 라인은 방향 규칙을 알고있는 라인생성기를 통해 생성 가능하다.
  - [x] 이동 가능한 방향은 '왼쪽', '오른쪽', '중립' 이다.
  - [x] 라인의 이동 방향은 다음과 같은 규칙을 가진다.
    - [x] 라인의 이전 이동 방향이 '오른쪽'일 경우, 현재 이동 방향은 '왼쪽'이어야 한다.
    - [x] 라인의 이전 이동 방향이 '왼쪽'일 경우, 현재 이동 방향은 '오른쪽' 또는 '중립'이어야 한다.
    - [x] 라인의 이전 이동 방향이 '중립'일 경우, 현재 이동 방향은 '오른쪽' 또는 '중립'이어야 한다.
    - [x] 라인의 첫 번째 이동 방향에는 '왼쪽'이 올 수 없다.
    - [x] 라인의 마지막 이동 방향에는 '오른쪽'이 올 수 없다.

#### Prize
- [x] 사다리 게임의 상품에 이름을 부여할 수 있다.
  - [x] 이름의 길이가 1~5자가 아닐 경우 예외를 발생시킨다.
  - [x] 이름 내에 공백이 존재할 경우 예외를 발생시킨다.

#### Prizes
- [x] 사다리 게임의 상품들을 가진다.
  - [x] 상품의 수가 2~10 범위 내에 있지 않을 경우 예외를 발생시킨다.
