package domain;

public class Result {

    private final String value;

    public Result(final String value) {
        validateRangeOfValue(value);
        this.value = value;
    }

    private void validateRangeOfValue(final String value) {
        if (value.length() < 1) {
            throw new IllegalArgumentException("결과 값의 길이는 1이상만 가능합니다.");
        }
    }

    public String getValue() {
        return this.value;
    }
}
