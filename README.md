# 문자열 덧셈 계산기

## Todo
* 커스텀 구분자가 없다면 쉼표(,) 또는 콜론(:) 구분자를 기준으로 각 숫자의 합을 반환
    * "1,2:3" -> 1 + 2 + 3 = 6
* 숫자만 있다면 숫자로 변환 후 반환
* 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException throw

## Done
* null, 빈 문자열 일 경우 0 반환
* 커스텀 구분자를 포함하는지 확인 ("//"와 "\n")
    * "//;\n1;2;3" -> 1 + 2 + 3 = 6
    * "//;\n1,2,3" -> RuntimeException

# 사다리게임



# java-ladder
사다리타기 미션 저장소

## 우아한테크코스 코드리뷰
* [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)