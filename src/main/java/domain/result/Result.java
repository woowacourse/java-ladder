package domain.result;

import java.util.Objects;

public class Result {

    private static final int MIN_VALUE_LENGTH = 1;
    private static final int MAX_VALUE_LENGTH = 5;

    private final String value;

    public Result(String value) {
        validateLength(value);
        this.value = value;
    }

    private void validateLength(String value) {
        if (value.length() < MIN_VALUE_LENGTH || MAX_VALUE_LENGTH < value.length()) {
            throw new IllegalArgumentException("실행 결과는 1~5자 사이여야 합니다.");
        }
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return Objects.equals(value, result.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
