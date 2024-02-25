package domain;

public class Result {
    private static final int MIN_RESULT_LENGTH = 1;
    private static final int MAX_RESULT_LENGTH = 5;
    private static final String INVALID_RESULT_LENGTH =
            "실행 결과는 " + MIN_RESULT_LENGTH + "자 이상, " + MAX_RESULT_LENGTH + "자 이하여야 합니다.";

    private final String result;

    public Result(final String value) {
        validateResultLength(value);
        this.result = value;
    }

    private void validateResultLength(final String value) {
        if (value.length() > MAX_RESULT_LENGTH) {
            throw new IllegalArgumentException(INVALID_RESULT_LENGTH);
        }

        if (value.isEmpty()) {
            throw new IllegalArgumentException(INVALID_RESULT_LENGTH);
        }
    }

    public String getValue() {
        return result;
    }
}
