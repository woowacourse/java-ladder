package laddergame.domain.result;

import java.util.Objects;

public class Result {

    public static final String INVALID_INCLUSION = " ";
    private final String result;

    public Result(final String result) {
        validateNullOrEmpty(result);
        validateBlank(result);
        this.result = result;
    }

    private void validateNullOrEmpty(final String result) {
        if (result == null || result.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 실행 결과는 null 이거나 빈 값일 수 없습니다.");
        }
    }

    private void validateBlank(final String result) {
        if (result.contains(INVALID_INCLUSION)) {
            throw new IllegalArgumentException("[ERROR] 실행 결과에 공백이 포함될 수 없습니다.");
        }
    }

    @Override
    public boolean equals(final Object diffResult) {
        if (this == diffResult) {
            return true;
        }
        if (diffResult == null || getClass() != diffResult.getClass()) {
            return false;
        }
        Result result1 = (Result) diffResult;
        return result.equals(result1.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }
}
