# java-ladder

###기능 목록

1. [입력] 게임을 실행 할 이름을 입력받는다.
    - [예외처리] 아무것도 입력 받지 않았을 경우
    - [예외처리] "," 입력형식이 맞지 않을 경우
    - [예외처리] 이름이 하나만 입력 됐을 경우
    - [예외처리] 이름에 빈칸이 있는 경우
    - [예외처리] 이름이 5글자 이상일 경우
    - [예외처리] 이름이 중복된 경우

2. [입력] 실행 결과를 입력 받는다.
    - [예외처리] 아무것도 입력 받지 않았을 경우
    - [예외처리] "," 입력형식이 맞지 않을 경우
    - [예외처리] 결과가 인원 수와 다를 경우
    
3. [입력] 최대 사다리 높이를 입력 받는다.
    - [예외처리] 아무것도 입력 받지 않았을 경우
    - [예외처리] 문자를 입력 받았을 경우
    - [예외처리] 음수를 입력했을 경우

4. [사다리 생성] 사다리를 생성한다.
    - 입력받은 높이만큼 사다리 ROW 초기화
    - 입력받은 사람수만큼 사다리 COLUMN 초기화

5. [사다리 연결] 랜덤으로 사다리를 연결한다.
    - [예외처리] 연속으로 2번 연결되는 경우

6. [출력] 게임 참가자, 결과와 함께 사다리를 출력한다.

7. [입력] 결과를 보고싶은 사람의 이름을 입력받는다.
    - [예외처리] 아무것도 입력받지 않은 경우
    - [예외처리] 참가자의 이름 또는 "all"이 아닌 경우
    
8. [사다리게임 수행] 사다리게임을 수행하고 도착지를 알아낸다.

9. [출력] 도착지를 출력한다.
    - [예외처리] "all"의 경우, 모든 참가자와 도착지를 출력한다.



# 문자열 덧셈 계산기

### 기능 목록

1. [입력] 문자열 입력 받기
    - [예외처리] 음수와 숫자 이외의 값은 runtimeException
    - [예외처리] 빈문자열이나 null이면, 0 반환
    - [예외처리] 숫자 하나만 입력한 경우, 해당 숫자 반환

2. [분리] 구분자로 숫자 분리
    - "//" 와 "\n" 사이에 있는 것을 커스텀 구분자로 선택
    - "," , ":" , 커스텀 구분자로 숫자를 분리

3. [연산] 분리한 숫자들의 합을 return
