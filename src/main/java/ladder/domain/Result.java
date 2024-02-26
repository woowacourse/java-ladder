package ladder.domain;

public class Result {

    public static final int MAX_RESULT_LENGTH = 5;

    private final String value;

    public Result(String rawValue) {
        String value = parse(rawValue);
        validate(value);
        this.value = value;
    }

    private String parse(String value) {
        return value.trim();
    }

    private void validate(String value) {
        validateMinLength(value);
        validateMaxLength(value);
    }

    private void validateMinLength(String value) {
        if (value.isEmpty()) {
            throw new IllegalArgumentException("결과는 1글자 이상이어야 합니다.");
        }
    }

    private void validateMaxLength(String value) {
        if (value.length() > MAX_RESULT_LENGTH) {
            throw new IllegalArgumentException("결과는 5글자 이하여야 합니다.");
        }
    }
}
