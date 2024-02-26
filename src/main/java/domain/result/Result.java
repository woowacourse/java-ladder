package domain.result;

public class Result {
    private static final int MINIMUM_RESULT_LENGTH = 1;
    private static final int MAXIMUM_RESULT_LENGTH = 5;
    private static final String LENGTH_EXCEPTION_MESSAGE = "[ERROR] 실행 결과의 길이는 " + MINIMUM_RESULT_LENGTH +
            "보다 크거나, " + MAXIMUM_RESULT_LENGTH + "보다 작아야 합니다.";

    private final String result;

    public Result(final String result) {
        validateLength(result);
        this.result = result;
    }

    private void validateLength(final String result) {
        if (result.length() < MINIMUM_RESULT_LENGTH || result.length() > MAXIMUM_RESULT_LENGTH) {
            throw new IllegalArgumentException(LENGTH_EXCEPTION_MESSAGE);
        }
    }
}
