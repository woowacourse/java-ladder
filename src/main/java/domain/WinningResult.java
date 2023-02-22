package domain;

import exception.ErrorCode;
import type.LadderElementInformation;

public class WinningResult {
    private final String result;

    public WinningResult(String result) {
        validate(result);
        this.result = result;
    }

    private void validate(String result) {
        if (result.length() < LadderElementInformation.MIN_LENGTH.getLength()
                || result.length() > LadderElementInformation.MAX_LENGTH.getLength()) {
            throw new IllegalArgumentException(String.format(ErrorCode.LENGTH_OUT_OF_RANGE.getMessage(),
                            LadderElementInformation.MIN_LENGTH.getLength(),
                            LadderElementInformation.MAX_LENGTH.getLength()));
        }
    }

    public String getResult() {
        return result;
    }
}
