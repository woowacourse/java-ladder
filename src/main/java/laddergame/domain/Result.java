package laddergame.domain;

import static laddergame.utils.OptionalUtils.getValueAfterNullCheck;

public class Result {
    private static final String RESULT_VALUE_BLANK_EXCEPTION = "결과는 공백일 수 없습니다.";

    private final String value;

    public Result(final String inputValue) {
        final String value = getValueAfterNullCheck(inputValue);
        validateValue(value);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private void validateValue(final String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException(RESULT_VALUE_BLANK_EXCEPTION);
        }
    }
}
