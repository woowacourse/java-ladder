package domain.ladder;

import common.exception.model.ValidationException;

public class LadderResult {
    public static final String BLANK_ERROR_MESSAGE = "사다리 실행 결과는 공백일 수 없습니다";
    public static final String NULL_ERROR_MESSAGE = "사다리 실행 결과는 Null 일 수 없습니다";
    public static final String LENGTH_ERROR_MESSAGE = String.format("사다리 실행 결과의 길이는 %d 이상, %d 이하여야 합니다",
            LadderResult.LENGTH_MIN, LadderResult.LENGTH_MAX);
    public static final int LENGTH_MIN = 1;
    public static final int LENGTH_MAX = 5;

    private final String value;

    public LadderResult(final String value) {
        validate(value);
        this.value = value;
    }

    private void validate(final String value) {
        validateNull(value);
        validateLength(value);
        validateBlank(value);
    }

    private void validateNull(final String value) {
        if (value == null) {
            throw new ValidationException(NULL_ERROR_MESSAGE);
        }
    }

    private void validateLength(final String value) {
        if (value.length() < LENGTH_MIN || value.length() > LENGTH_MAX) {
            throw new ValidationException(LENGTH_ERROR_MESSAGE);
        }
    }

    private void validateBlank(final String value) {
        if (value.isBlank()) {
            throw new ValidationException(BLANK_ERROR_MESSAGE);
        }
    }

    public String getValue() {
        return value;
    }
}
