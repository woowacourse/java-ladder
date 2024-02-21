### 도메인 기능 목록

1. Player
    - 이름은 최소 1자 이상, 최대 5자 이름만 가능하다.
    - 영어, 한글만 입력 가능하다.
2. Players
    - 플레이어들을 갖는 일급 컬렉션.
    - 인원은 최소 2명 이상, 최대 10명 이하만 가능하다.

3. Height
    - 높이는 최소 2이상, 최대 10이하만 가능하다.

4. Point
    - 방향값을 갖는 Direction을 갖는다.

5. Direction
    - LEFT, RIGHT, DOWN 세 방향을 갖는 enum.
    - 1/2 확률로 RIGHT와 DOwN을 생성하도록 한다.

6. Line
    - Point들을 가지는 일급 컬렉션.
    - 각 Point가 가질 수 있는 Direction을 지정하며 생성한다.
    - 이전 Point가 RIGHT면 LEFT를 할당한다.
    - 이전 Point가 RIGHT가 아니면 1/2 확률로 RIGHT 또는 DOWN을 할당한다.
    - 쳣번째 Point면, 1/2 확률로 RIGHT 또는 DOWN을 할당한다.
    - 마지막 Point면, 이전이 RIGHT면 LEFT, 아니면 DOWN,

7. Ladder
    - Line들을 가지는 일급 컬렉션.
    - 생성자에서 참가자, 최대 높이, 랜덤 구현체를 바탕으로 사다리를 만든다.

### 입출력 기능 목록

1. 이름 입력받는다.
    - 쉼표(,)를 기준으로 구분한다.


2. 사다리 최대 높이를 입력받는다.
    - 숫자만 입력 가능하다.

3. 폭은 최대 닉네임만큼 여백을 생성한다.
