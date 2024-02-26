package ladder.domain;

public class Result {

    private final String value;

    public Result(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        validateMinLength(value);
    }

    private void validateMinLength(String value) {
        if (value.isEmpty()) {
            throw new IllegalArgumentException("결과는 1글자 이상이어야 합니다.");
        }
    }
}
