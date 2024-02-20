# 사다리타기

## 기능 요구사항

- 입력
    - [ ] 사용자로부터 이름을 입력받는다.
        - [ ] **[예외 상황]** 사용자의 입력은 빈 값이거나 null이면 안된다.
        - [ ] **[예외 상황]** 이름에 공백은 허용하지 않는다.
        - [ ] **[예외 상황]** 이름에 쉼표를 제외한 특수문자는 허용하지 않는다.
    - [ ] 사용자로부터 사다리 높이를 입력받는다.
- 이름
    - [X] **[예외 상황]** 이름의 길이는 최대 5글자이다.
    - [X] **[예외 상황]** 이름의 길이는 최소 1글자 이상이다.
- 이름 컬렉션
    - [ ] **[예외 상황]** 중복된 이름은 허용하지 않는다.
- 사다리
    - [ ] 사다리를 생성할 수 있다.
    - [ ] 사람이 1명인 경우, 가로선을 그리지 않는다.
    - [ ] 사다리를 좌표로 구분하여 각 좌표마다 가로선을 그릴지 말지 결정한다.
        - [ ] (0~1) 사이의 값을 뽑고, 0이면 false, 1이면 true
        - [ ] 사다리의 가로선이 겹치면 그릴지 여부를 결정하지 않고 바로 넘어간다.
        - [ ] 사다리의 가로선은 겹치면 안된다.
- 출력
    - [ ] 만들어진 사다리를 출력할 수 있다.
    - [ ] 사다리 폭은 이름이 가장 긴 사람의 이름 길이와 같다.

