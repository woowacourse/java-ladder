package domain.ladder;

import common.exception.model.ValidationException;

public class LadderResult {
    public static final String LADDER_RESULT_BLANK = "사다리 실행 결과는 공백일 수 없습니다";
    public static final String LADDER_RESULT_NULL = "사다리 실행 결과는 Null 일 수 없습니다";
    public static final String LADDER_RESULT_LENGTH = String.format("사다리 실행 결과의 길이는 %d 이상, %d 이하여야 합니다",
            LadderResult.LADDER_RESULT_LENGTH_MIN, LadderResult.LADDER_RESULT_LENGTH_MAX);
    public static final int LADDER_RESULT_LENGTH_MIN = 1;
    public static final int LADDER_RESULT_LENGTH_MAX = 5;

    private final String value;

    public LadderResult(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        validateNull(value);
        validateLength(value);
        validateBlank(value);
    }

    private void validateBlank(String value) {
        if (value.isBlank()) {
            throw new ValidationException(LADDER_RESULT_BLANK);
        }
    }

    private void validateNull(String value) {
        if (value == null) {
            throw new ValidationException(LADDER_RESULT_NULL);
        }
    }

    private void validateLength(String value) {
        if (value.length() < LADDER_RESULT_LENGTH_MIN || value.length() > LADDER_RESULT_LENGTH_MAX) {
            throw new ValidationException(LADDER_RESULT_LENGTH);
        }
    }

    public String getValue() {
        return value;
    }
}
