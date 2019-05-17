# 계산기 TDD 예제

## To-do-list

- ~~문자열을 구분자를 기준으로 분리해라~~
    - "" -> null
    - "1,2,3" -> {1, 2, 3}
    - "1,2:3" -> {1, 2, 3}
- ~~커스텀 구분자를 지정할 수 있다.~~
    - "//;\n1;2;3" -> {1, 2, 3}
- ~~숫자 배열을 더해라~~
    - "1,2,3"
    - "1,2:3"
    - "//;\n1;2;3"
- ~~음수를 받으면 RuntimeException 에러를 throw 한다.~~
- ~~문자열 구분 메소드 리팩토링 필요~~

# 사다리 게임

## To-do-list
- ~~라인이 겹치면 안 된다. (isConsecutive())~~
    - true, true -> true
    - true, false -> false
    - false, true -> false
- ~~라인은 위치를 받았을 때 진행할 방향을 알려줘야 한다.~~
    - 0, {true, false} -> RIGHT
    - 1, {true, false} -> LEFT
    - 0, {false, true} -> STRAIGHT
- ~~사다리 타기를 진행해서 결과를 얻는다.~~
    - lines, {"pobi" : 0, "crong" : 1, "honux": 2} -> {"pobi" : 2, "crong" :1, "honux" : 0}
- ~~사다리 게임 결과를 생성한다.~~
    - {"pobi" : 2, "crong" :1, "honux" : 0}, {"꽝", "2000", "3000"} -> {"honux" : "꽝", "crong" : "2000", "pobi" : "3000"}
- ~~플레이어 클래스 추가.~~
- ~~라인 생성 기능 추가.~~
- ~~래더 게임 클래스 게임 진행 로직 추가~~
- ~~이름 입력 기능 추가~~
- ~~높이 입력 기능 추가~~
- ~~보상 입력 기능 추가~~
- ~~사다리 출력 기능 추가~~
- ~~결과 출력 기능 추가~~
- ~~이름 입력 예외 처리 추가 (이름은 5글자 이내여야 함)~~
- ~~보상 입력 예외 처리 추가 (보상도 5글자 이내여야 함)~~
- ~~예외 처리 단위테스트 추가~~
- ~~리팩토링~~

## 리팩토링
- ~~불필요한 공백 라인을 지운다.~~
- ~~Player의 name이 null 인지 체크한다.~~
- ~~Player의 position 값을 검증한다.~~
- ~~Direction enum 을 쓰지 말고 구현한다.~~
- ~~Line 생성자에서 points 값을 바로 받지 않고 예외처리를 먼저 해라.~~
- Player 와 Reward 도 Line 처럼 일급컬렉션으로 구현할 수 있지 않을까?
- LadderGame의 goDown()의 리턴타입을 Result 객체로 받아서 OutputView에서 출력을 정의하는 방법은 어떨까? 장점은 무엇일까?
- 내부 변수를 사용하면 메서드의 파라미터 수나 메서드 수를 줄일 수 있다.
- 메서드 리네이밍

## 다시 짜자
1. players - player, Rewards - reward 일급컬렉션 사용.
2. 컨트롤러는 메시지만 보내야한다. 복잡한 로직이 있으면 안 됨. (그래서 일급 컬렉션을 사용하는 것)
3. 프러덕션 코드를 수정하기 위해서는 테스트 코드를 먼저 짜라
4. 컨트롤러에서 게임 로직과 결과를 조합하는 부분이 섞여있으면 안 된다. 게임 로직(플레이어 시작점, 끝점 페어)은 사다리 게임 엔진
이라는 도메인 객체를 하나 만들어서 처리해라. 
5. 원시값, 문자열은 다 객체로 포장한다.

- (계산기) PositiveNumber 클래스를 만들어 사다리 높이를 입력받는다.
- (true,true), (true,false) 와 같이 두 개의 불리언 값을 객체로 만들면 어떨까?
- Line 에서 getDirection 으로 나아갈 방향을 찾는 것보다 이러한 역할을 하는 객체를 만들어라.
    
    
## To-do-list
1. Player의 현재 위치를 나타내는 Position 객체를 생성한다.
    - ~~현재 위치는 0 이상이어야한다.~~
    - 현재 위치는 전체 플레이어 수보다 작아야한다.