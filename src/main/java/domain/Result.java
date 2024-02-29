package domain;

public class Result {

    private static final int MINIMUM_RESULT_LENGTH = 1;
    private static final int MAXIMUM_RESULT_LENGTH = 5;
    public static final String INVALID_RESULT_LENGTH = "실행 결과는 " + MINIMUM_RESULT_LENGTH + "글자 이상 " + MAXIMUM_RESULT_LENGTH + "글자 이하이어야 합니다.";
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
