# 주요 구현 기능

- 이름을 가진 N명의 사용자를 생성한다.
- 사다리를 생성한다.
    - 사다리는 최대 사다리 높이만큼 라인(사다리의 가로줄)을 생성한다.
    - 사다리의 라인의 너비는 입력한 사용자의 수만큼 이동 방향을 가진다.
      - 왼쪽, 오른쪽, 중립
    - 라인의 이동 방향은 다음과 같은 규칙을 가진다.
      - 라인의 이전 이동 방향이 '오른쪽'일 경우, 현재 이동 방향은 '왼쪽'이어야 한다.
      - 라인의 이전 이동 방향이 '왼쪽'일 경우, 현재 이동 방향은 '오른쪽' 또는 '중립'이어야 한다.
      - 라인의 이전 이동 방향이 '중립'일 경우, 현재 이동 방향은 '오른쪽' 또는 '중립'이어야 한다.
      - 라인의 첫 번째 이동 방향에는 '왼쪽'이 올 수 없다.
      - 라인의 마지막 이동 방향에는 '오른쪽'이 올 수 없다.

# 입출력 기능

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

### 예외 처리 기능

- 사용자의 이름이 1글자 미만 5글자 초과인 경우 예외로 처리한다.
- 사용자의 이름이 영문 대소문자가 아닌 경우 예외로 처리한다.
- 사용자의 이름 내에 공백이 존재한다면 예외로 처리한다.
- 입력한 사용자의 이름의 개수가 2명 미만 10명 초과인 경우 예외로 처리한다.
- 중복된 사용자의 이름이 있다면 예외로 처리한다.
- 최대 사다리 높이가 50 이하의 양의 정수가 아니라면 예외로 처리한다.
