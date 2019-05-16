# 문자열 덧셈 계산기
## To-do
   * setAdditionalSeparatorsFrom 리팩토링
     - 현재는 한 메소드에서 구분자를 저장하고, 남은 문자열을 리턴해주는 일을 모두하고 있다.
     - 커스텀 구분자만 입력됐을 때, 커스텀 구분자 없이 입력됐을 때 처리
   * 커스텀 구분자가 정규표현식 Token인 경우 예외 처리
     - Pattern.quote()
## Done
   * 문자열 계산기를 구현해야 합니다.
   * 숫자 덧셈 기능
   * 구분자를 기준으로 문자열을 분리해주는 기능
   * 숫자열을 분리하고 커스텀 구분자를 추가저장 하는기능
   * splitBySeparator 인자 리펙토링
   * 숫자를 구분해주는 기능
   * 숫자 이외의 값/음수를 입력하였을 때 RuntimeException을 throw하는 기능 
   * Converter에 입력된 문자열 리스트에 빈 문자열이 포함될 경우 제거하는 기능


# 사다리 게임
## To-do   
+ 1단계
   * OutputView의 printCrossbars 리팩토링
   * Ladder에서 foreach getter사용하지 않고 하는 방법?
   * Ladder 클래스 field명 변경
   * Ladder Getter 이름 변경
   * Ladder Game 클래스의 LAST_DMMY_SPACE 리네임
+ 2단계
   * 결과를 보고 싶은 사람을 입력받으면 결과를 출력해줘야 합니다.
     - all을 입력하면 경우에는 전부 다 출력합니다.
   * Player, ResultItem 중복
   * InputView 메소드 기능 중복(player,item)
   * 사다리결과 만드는 기능에서 getter 빼는 방법 생각

## Done
   * player 이름이 공백, null일 때 예외 처리
   * 입력받은 사람의 수에 따라서 crossbars를 만들어야 합니다.
     - crossbars에는 연속된 crossbar가 있어서는 안 됩니다.
   * 랜덤한 crossbar 리스트를 생성해 Crossbars 객체를 만들어주는 기능
   * crosspoints 리스트를 입력받아 Ladder를 생성합니다.
     - crossbars의 갯수는 1 이상이여야 합니다.
   * 참여할 사람 이름 길이는 최대 5글자까지 부여할 수 있습니다.
   * 참여할 사람 이름을 입력받아야 합니다.
     - 쉼표로 사람 이름을 구분할 수 있어야 합니다.
   * 사다리게임 1단계 결과를 출력헤주는 기능을 만들어야 합니다.
   * crossbar는 '-' 5개로 구성되어 있습니다.
   * all이라는 이름은 존재하면 안됩니다.
   * crossbars가 한 칸을 지났을 때 바뀌는 위치를 알려주는 기능을 추가하였습니다.
   * 이동 방향을 알려주는 corsspoints를 구현해야 합니다.
   * 실행 결과를 입력 받아야합니다.
     - 실행 결과의 길이는 최대 5입니다.
     - 실행 결과들의 개수는 player의 수와 동일해야 합니다.
     - 공백, null을 입력받으면 안됩니다.   


## 우아한테크코스 코드리뷰
* [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

