# 기능 명세

## View
- [x] 사다리 게임에 참여하는 사람의 이름을 입력 받는다.
  - [x] 사람의 이름은 5글자 이하여야 한다.
  - [x] 사람의 이름을 쉼표(,)로 구분해야 한다. (최소 2명 이상)
  - [x] 사람의 이름은 중복일 수 없다.
- [x] 사다리의 높이를 입력받는다.
  - [x] 사다리의 높이는 자연수여야 한다.
- [x] 만들어진 사다리 모양과 사람이름, 결과를 출력해야 한다.
  - [x] 사람 이름은 최대 글자를 기준으로 출력한다.
  - [x] 결과는 최대 글자를 기준으로 하되 영어와 숫자는 1칸, 그 외 글자는 2칸으로 계산한다.
- [x] 실행 결과를 입력받는다.
  - [x] 실행 결과는 참가자의 수와 동일해야 한다.
- [x] 결과를 보고싶은 사람을 입력받는다.
  - [x] 참가자에 입력받은 이름이 없는 경우 에러 메세지를 출력한다.
- [x] 입력받은 참가자의 결과를 출력한다.
  - [x] all을 입력받는 경우 모두 출력한다.
  - [x] 모두 출력하지 않으면 한 명만 출력한다.
  - [x] 출력 후 all을 입력받을 때 까지 다시 결과를 출력할 참가자를 입력받는다.
  
## Util
- [x] Boolean 값 랜덤 생성을 한다.

## Model
- [x] Peoples를 생성한다.
  - [x] People를 생성한다.
- [x] Lines를 생성한다.
  - [X] Line을 생성한다.
- [x] Rewards를 생성한다.
  - [x] Reward를 생성한다.
- [x] LadderGame에서 사다리 최종 결과를 계산한다.




SimpleArrayList 기능 명세서
- [x] 기본 생성자를 이용하는 경우 크기 10의 배열 리스트를 생성한다.
  - [x] 생성자에 초기화할 정수를 전달하면 해당 크기의 배열 리스트를 생성한다.
- [x] add 메서드로 원소를 추가할 수 있다. 성공하면 true를 반환하고 실패하면 false를 반환한다.
  - [x] 원소 추가 시 특정 인덱스를 전달하면 해당 위치에 원소를 추가한다. 기존 크기 이하에만 가능하다.
  - [ ] 기존 크기를 다 사용한 경우 크기를 늘려 재할당한다.
- [x] set 메서드를 이용해 특정 인덱스의 값을 변경한다. 범위를 벗어날 수 없다. 반환값은 기존 값이다.
- [x] get 메서드를 이용해 특정 인덱스의 값을 가져온다. 범위를 벗어날 수 없다.
- [x] contains 메서드를 이용해 특정 값이 있는지 확인한다. 있는 경우 true, 없는 경우 false를 반환한다.
- [ ] indexOf 메서드를 이용해 특정 값의 인덱스를 가져온다. 없는 경우 -1을 반환한다.
- [ ] size 메서드를 이용해 현재 값들의 갯수를 반환한다.
- [ ] inEmpty 메서드를 이용해 리스트가 비어있는지 확인한다. 비어있는 경우 true, 비어있지 않은 경우 false를 반환한다.
- [ ] remove 메서드를 이용해 특정 값을 제거한다. 제거에 성공하는 경우 true, 실패하는 경우 false를 반환한다.
- [ ] clear 메서드를 이용해 리스트의 값들을 전부 제거한다.
