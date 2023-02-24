package domain;

import java.util.Objects;

public class Result {

    public static final int MIN_LENGTH = 1;
    public static final int MAX_LENGTH = 5;

    private final String result;

    public Result(String result) {
        validateResultLength(result);
        this.result = result;
    }

    private void validateResultLength(String result) {
        if (result.isBlank() || result.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(
                    String.format("결과는 %d자 이상 %d자 이하여야 합니다.", MIN_LENGTH, MAX_LENGTH));
        }
    }

    public String getResult() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Result result1 = (Result) o;
        return Objects.equals(result, result1.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }
}
