package domain.ladder;

import common.exception.message.ExceptionMessage;
import common.exception.model.ValidationException;

public class LadderResult {
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
            throw new ValidationException(ExceptionMessage.LADDER_RESULT_BLANK);
        }
    }

    private void validateNull(String value) {
        if (value == null) {
            throw new ValidationException(ExceptionMessage.LADDER_RESULT_NULL);
        }
    }

    private void validateLength(String value) {
        if (value.length() < LADDER_RESULT_LENGTH_MIN || value.length() > LADDER_RESULT_LENGTH_MAX) {
            throw new ValidationException(ExceptionMessage.LADDER_RESULT_LENGTH);
        }
    }

    public String getValue() {
        return value;
    }
}
