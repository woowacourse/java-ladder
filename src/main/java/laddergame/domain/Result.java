package laddergame.domain;

import java.util.Optional;

public class Result {
    private static final String RESULT_VALUE_NULL_EXCEPTION = "결과는 null일 수 없습니다.";
    private static final String RESULT_VALUE_BLANK_EXCEPTION = "결과는 공백일 수 없습니다.";

    private final String value;

    public Result(final String inputValue) {
        final String value = getValue(inputValue);
        validateValue(value);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private  String getValue(final String inputValue) {
        return Optional.ofNullable(inputValue).orElseThrow(() -> new IllegalArgumentException(RESULT_VALUE_NULL_EXCEPTION));
    }

    private void validateValue(final String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException(RESULT_VALUE_BLANK_EXCEPTION);
        }
    }
}
