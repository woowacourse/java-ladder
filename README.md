# 요구사항 해석

> 다시 구현하는 것인 만큼, 조금 난이도를 높이기 위해 생성되는 사다리에 제약 사항을 추가했습니다.

- 참가자 관련 요구 사항
    1. 참가자는 최대 10명까지 입력 가능하다
    2. 참가자 이름의 구분은 ","를 기준으로 수행된다.
- 참가자 이름 관련 요구 사항
    1. 참가자 이름은 최소 한글자 최대 5글자까지 부여할 수 있다.
    2. 참가자 이름은 중복될 수 없다.
    3. 참가자 이름에는 알파벳 대소문자, 숫자 만 입력할 수 있다.
    4. 참가자 이름은 all이 될 수 없다.
- 사다리 관련 요구 사항
    1. 어느 한 위치에서 왼쪽과 오른쪽에 동시에 발판이 있을 수 없다.
        - 즉, 다음과 같은 사다리는 생성되면 안된다.
            ```
             |-----|     |
             |-----|-----|
            ```
    2. 사다리의 높이는 최소 2, 최대 20이다.
    3. 두 참여자 사이에는 최소한 한개 이상의 발판이 있어야 한다.
        - 즉, 다음과 같은 사다리는 생성되면 안된다.
            ```
             |-----|     |
             |-----|     |
             |-----|     |
            ```
- 상품 관련 요구 사항
    1. 상품은 사다리 타기의 결과로 참여자와 1대 1 매칭 될 어떤 것을 말한다.
    2. 상품은 최소 한글자 최대 5글자까지 부여할 수 있다.
- 안정적인 프로그램 실행을 위한 요구사항
    1. 잘못된 입력이 발생한 경우, 적절한 에러 메세지를 출력한 뒤 해당 위치부터 다시 입력을 수행한다.
    2. 재입력은 무한히 시도될 수 있어야 한다.
- 출력 요구 사항
    1. 사다리의 가로(-)는 최대 이름 길이로 고정한다.
    2. 사람의 이름은 사다리의 세로(|) 에 맞춰 정렬한다.
    3. 사람의 이름이 최대 이름 길이보다 작을경우 다음과 같은 규칙으로 공백을 추가한다.
        1. 이름 맨 뒤에 공백 문자를 추가한다.
        2. 앞에서 추가된 공백 문자를 포함한 이름의 길이가 최대 이름 길이 보다 작을 경우, 공백을 포함한 이름의 길이가 최대 이름 길이가 되도록 공백 문자를 이름 앞에 추가한다.

# 기능 목록

- [ ] 참가자 이름 입력 기능
- [x] 참가자 생성 기능
- [ ] 사다리 높이 입력 기능
- [ ] 상품 이름 입력 기능
- [x] 상품 생성 기능
- [x] 사다리 생성 기능
- [ ] 사다리 출력 기능
- [ ] 사다리 타기 실행 기능
- [ ] 사다리 타기 결과 출력 기능
