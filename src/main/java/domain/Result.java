package domain;

public class Result {

    private final String value;

    public Result(String value) {
        validateLength(value);
        this.value = value;
    }

    private void validateLength(String value) {
        if (value.length() < 1 || 5 < value.length()) {
            throw new IllegalArgumentException("실행 결과는 1~5자 사이여야 합니다.");
        }
    }

    public String getValue() {
        return this.value;
    }
}
