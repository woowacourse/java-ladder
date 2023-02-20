package laddergame.domain;

import laddergame.constant.ErrorCode;

public class Prize {

    private final String value;

    public Prize(String value) {
        validatePrizeValue(value);
        this.value = value;
    }

    private void validatePrizeValue(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(ErrorCode.EMPTY_INPUT.getCode());
        }
    }
}
