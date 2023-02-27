package ladder.domain;

import ladder.error.ErrorMessage;

public class Result {
    private static final int MAX_RESULT_LENGTH = 5;
    private static final String COMMA = ",";

    private final String result;

    public Result(String result) {
        validate(result);
        this.result = result;
    }

    private void validate(String result) {
        validateNotNull(result);
        validateDoesNotContainComma(result);
        validateLength(result);
    }

    private void validateNotNull(String result) {
        if (result == null) {
            throw new IllegalArgumentException(ErrorMessage.RESULT_IS_NULL.getMessage());
        }
    }

    private void validateDoesNotContainComma(String result) {
        if (result.contains(COMMA)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RESULT_FORMAT.getMessage());
        }
    }

    private void validateLength(String result) {
        if (result.length() > MAX_RESULT_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RESULT_LENGTH.getMessage());
        }
    }

    public String getResult() {
        return result;
    }
}
