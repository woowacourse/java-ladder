package laddergame.domain.result;

import java.util.Objects;

public class Result {

    public static final String INVALID_INCLUSION = " ";

    private final String resultName;

    public Result(final String resultName) {
        validateNullOrEmpty(resultName);
        validateBlank(resultName);
        this.resultName = resultName;
    }

    private void validateNullOrEmpty(final String result) {
        if (Objects.isNull(result) || result.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 실행 결과는 null 이거나 빈 값일 수 없습니다.");
        }
    }

    private void validateBlank(final String result) {
        if (result.contains(INVALID_INCLUSION)) {
            throw new IllegalArgumentException(String.format("[ERROR] 실행 결과에 공백이 포함될 수 없습니다. 입력된 값 : %s", result));
        }
    }

    @Override
    public boolean equals(final Object diffResultName) {
        if (this == diffResultName) {
            return true;
        }
        if (diffResultName == null || getClass() != diffResultName.getClass()) {
            return false;
        }
        Result result1 = (Result) diffResultName;
        return resultName.equals(result1.resultName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resultName);
    }

    public String getResultName() {
        return resultName;
    }
}
