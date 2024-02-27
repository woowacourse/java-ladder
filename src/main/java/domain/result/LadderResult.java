package domain.result;

import domain.result.message.ResultExceptionMessage;

public class LadderResult {
    public static final int MIN_RESULT_LENGTH = 1;
    public static final int MAX_RESULT_LENGTH = 5;

    private final String result;

    public LadderResult(final String result) {
        validate(result);
        this.result = result;
    }

    private void validate(final String result) {
        validateLAdderResultIsBlank(result);
        validateLadderResultLength(result);
    }

    private void validateLAdderResultIsBlank(final String result) {
        if (result.isBlank()) {
            throw new IllegalArgumentException(ResultExceptionMessage.LADDER_RESULT_BLANK);
        }
    }

    private void validateLadderResultLength(final String result) {
        int resultLength = result.length();
        if (resultLength < MIN_RESULT_LENGTH || resultLength > MAX_RESULT_LENGTH) {
            throw new IllegalArgumentException(ResultExceptionMessage.LADDER_RESULT_LENGTH);
        }
    }
}
