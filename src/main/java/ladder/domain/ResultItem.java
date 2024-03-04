package ladder.domain;

public class ResultItem {

    public static final int MAX_LENGTH = 5;

    private final String value;

    public ResultItem(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        validateNotEmpty(value);
        validateMaxLength(value);
    }

    private void validateNotEmpty(String value) {
        if (value.isEmpty()) {
            throw new IllegalArgumentException("결과 항목 값이 1글자 미만입니다.");
        }
    }

    private void validateMaxLength(String value) {
        if (value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("결과 항목 값이 5글자 초과입니다.");
        }
    }

    public String getValue() {
        return value;
    }
}
