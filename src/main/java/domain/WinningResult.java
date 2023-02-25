package domain;

import exception.ErrorCode;

public class WinningResult {
    private static final int MAX_RESULT = 5;
    private static final int MIN_RESULT = 1;
    private final String result;

    public WinningResult(String result) {
        validate(result);
        this.result = result;
    }

    private void validate(String result) {
        if (result.length() < MIN_RESULT || result.length() > MAX_RESULT) {
            throw new IllegalArgumentException(
                    String.format(ErrorCode.RESULT_OUT_OF_RANGE.getMessage(), MIN_RESULT, MAX_RESULT));
        }
    }

    public String getResult() {
        return result;
    }
}
