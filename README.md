# 문자열 덧셈 계산기
## To-do
   * 문자열 계산기를 구현해야 합니다.
   * setAdditionalSeparatorsFrom 리팩토링
     - 현재는 한 메소드에서 구분자를 저장하고, 남은 문자열을 리턴해주는 일을 모두하고 있다.
     - 커스텀 구분자만 입력됐을 때, 커스텀 구분자 없이 입력됐을 때 처리
   * 커스텀 구분자가 정규표현식 Token인 경우 예외 처리
     - Pattern.quote()
## Done
   * 숫자 덧셈 기능
   * 구분자를 기준으로 문자열을 분리해주는 기능
   * 숫자열을 분리하고 커스텀 구분자를 추가저장 하는기능
   * splitBySeparator 인자 리펙토링
   * 숫자를 구분해주는 기능
   * 숫자 이외의 값/음수를 입력하였을 때 RuntimeException을 throw하는 기능 
   * Converter에 입력된 문자열 리스트에 빈 문자열이 포함될 경우 제거하는 기능
# java-ladder
사다리타기 미션 저장소

## 우아한테크코스 코드리뷰
* [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)



//;\n
""
;
