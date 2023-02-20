package domain;

import java.util.Objects;

public class Result {
    private final String result;

    public Result(String result) {
        validateResultLength(result);
        this.result = result;
    }

    private void validateResultLength(String result) {
        if (result.isBlank()) {
            throw new IllegalArgumentException("결과는 공백일 수 없습니다.");
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
