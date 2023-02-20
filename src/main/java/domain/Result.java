package domain;

public class Result {

    private final String value;

    public Result(final String value) {
        validateRangeOfValue(value);
        this.value = value;
    }

    private void validateRangeOfValue(final String value) {
        if (value.length() < 1 || value.length() > 5) {
            throw new IllegalArgumentException("결과 값의 길이는 1이상 5이하만 가능합니다.");
        }
    }
}
