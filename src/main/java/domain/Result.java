package domain;

public class Result {

    public static final String INVALID_RESULT_LENGTH = "실행 결과는 1글자 이상 5글자 이하이어야 합니다.";
    private static final int MINIMUM_RESULT_LENGTH = 1;
    private static final int MAXIMUM_RESULT_LENGTH = 5;
    private final String value;

    public Result(final String value) {
        validateResultLength(value);
        this.value = value;
    }

    private void validateResultLength(final String value) {
        if (value.length() < MINIMUM_RESULT_LENGTH || value.length() > MAXIMUM_RESULT_LENGTH) {
            throw new IllegalArgumentException(INVALID_RESULT_LENGTH);
        }
    }

    public String getValue() {
        return value;
    }
}
