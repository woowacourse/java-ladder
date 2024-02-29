package laddergame.domain.result;

import java.util.Objects;

public class Result {

    private final String result;

    public Result(final String result) {
        validateEmpty(result);
        this.result = result;
    }

    private void validateEmpty(final String result) {
        if (result == null || result.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 빈 결과를 입력할 수 없습니다.");
        }
    }

    public String getResult() {
        return result;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof final Result result1)) {
            return false;
        }
        return Objects.equals(result, result1.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }
}
