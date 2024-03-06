package ladder.domain.result;

import java.util.Objects;

public class Result {

    private static final int RESULT_LENGTH_MAX = 5;

    private final String value;

    public Result(String value) {
        validateLength(value);
        this.value = value;
    }

    private void validateLength(String value) {
        if (value.length() > RESULT_LENGTH_MAX) {
            throw new IllegalArgumentException("결과는 5글자 이내입니다.");
        }
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that instanceof Result result) {
            return Objects.equals(this.value, result.value);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
