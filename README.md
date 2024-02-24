# 구현할 기능 목록

## 도메인 기능

### User
- 사다리 게임에 참여하는 사람에 이름을 부여할 수 있다.
    - 이름의 길이가 1~5자가 아닐 경우 예외를 발생시킨다.
    - 이름이 영문 대소문자가 아닌 경우 예외를 발생시킨다.
    - 이름 내에 공백이 존재할 경우 예외를 발생시킨다.

### Users
- 사다리 게임의 사용자들을 가진다.
  - 사용자 수가 2~10 범위 내에 있지 않을 경우 예외를 발생시킨다.
  - 중복된 사용자의 이름이 있을 경우 예외를 발생시킨다.

### Ladder
- 사다리는 각각의 라인으로 이루어져 있다.
- 사다리의 라인 수는 사다리의 높이를 나타낸다.
  - 사다리의 높이가 1~50 범위 내에 있지 않을 경우 예외를 발생시킨다.

### Line
- 사다리의 가로줄에 해당하는 라인이다.
- 라인은 사다리를 타는 사람 수 만큼의 이동 방향을 가진다.
  - 이동 가능한 방향은 '왼쪽', '오른쪽', '중립' 이다.
  - 라인의 이동 방향은 다음과 같은 규칙을 가진다.
    - 라인의 이전 이동 방향이 '오른쪽'일 경우, 현재 이동 방향은 '왼쪽'이어야 한다.
    - 라인의 이전 이동 방향이 '왼쪽'일 경우, 현재 이동 방향은 '오른쪽' 또는 '중립'이어야 한다.
    - 라인의 이전 이동 방향이 '중립'일 경우, 현재 이동 방향은 '오른쪽' 또는 '중립'이어야 한다.
    - 라인의 첫 번째 이동 방향에는 '왼쪽'이 올 수 없다.
    - 라인의 마지막 이동 방향에는 '오른쪽'이 올 수 없다.


## 입출력 기능

## 입력

- 사용자 이름을 담은 문자열을 입력한다.
- 사용자의 이름은 쉼표(‘,’)를 기준으로 구분한다.
    - 구분된 사용자의 이름은 2명 이상 10명 이하여야 한다.
    - 각 사용자의 이름은 1글자 이상 5글자 이하여야 한다.
    - 각 사용자의 이름은 영문 대, 소문자로 한정한다.
- 최대 사다리 높이를 입력한다.
    - 최대 사다리 높이는 50 이하의 양의 정수여야 한다.

## 출력

- 이름을 먼저 출력하고 사다리를 출력한다.

### 이름 출력

- 5글자 미만의 이름은 공백을 추가한다.
    - 먼저, 이름의 맨 뒤에 한 칸의 공백을 추가한다.
    - 공백을 추가한 이름의 길이가 5글자 미만이라면, 이름의 앞에 공백을 더 추가하여 총 5글자가 되도록 한다.
- 각 이름 사이 공백은 1칸으로 한다.

### 사다리 출력

- 첫 번째 세로 라인 전까지의 공백은 4칸으로 한다.
- 이후 세로 라인과 세로 라인 사이 간격은 5칸으로 한다.
- 세로 라인 사이에 들어가는 라인은 ‘-’로 표시한다.
- 사다리 세로 라인의 길이는 최대 사다리 높이만큼 출력한다.
