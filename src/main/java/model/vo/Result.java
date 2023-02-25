package model.vo;

public class Result {
    private static final int MAXIMUM_RESULT_LENGTH = 5;
    private static final String MAXIMUM_RESULT_LENGTH_ERROR = "[ERROR] 게임 결과 입력값 길이는 %d 이하로만 가능합니다.";

    private final String result;

    public Result(String result) {
        validateResultLength(result);
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    private void validateResultLength(String result) {
        if (result.length() > MAXIMUM_RESULT_LENGTH) {
            throw new IllegalArgumentException(String.format(MAXIMUM_RESULT_LENGTH_ERROR, MAXIMUM_RESULT_LENGTH));
        }
    }
}
