# 문자열 덧셈 계산기

## Todo

## Done
* null, 빈 문자열 일 경우 0 반환
* 커스텀 구분자를 포함하는지 확인 ("//"와 "\n")
    * "//;\n1;2;3" -> 1 + 2 + 3 = 6
    * "//;\n1,2,3" -> RuntimeException
* 커스텀 구분자가 없다면 쉼표(,) 또는 콜론(:) 구분자를 기준으로 각 숫자의 합을 반환
    * "1,2:3" -> 1 + 2 + 3 = 6
* 숫자만 있다면 숫자로 변환 후 반환
* 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException throw

# 사다리게임
## Todo
* 사다리 높이 입력
* 사다리 높이 저장
    - 1 이상의 정수인지 검증
* 사다리의 한 층을 가진 Line 객체 구현
    - 이전 point가 true이면 해당 point는 무조건 false 저장
    - 이전 point가 false이면 해당 point는 boolean을 random으로 생성해 저장
* 입력 받은 사다리 높이만큼 Line을 가진 Ladder 객체 구현
* 사다리 출력

## Done
* 이름을 입력받고, 쉼표(,)를 기준으로 구분
* Player(name,position) 객체 생성
    - 올바른 이름인지 검증
        + 5글자 이하면 생성
        + 5글자 초과면 예외발생
        + null 또는 빈문자열 이면 예외발생


# java-ladder
사다리타기 미션 저장소

## 우아한테크코스 코드리뷰
* [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)