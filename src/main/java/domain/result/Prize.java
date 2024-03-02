package domain.result;

import java.util.Objects;

public class Prize {

    private static final int MAX_RESULT_LENGTH = 5;

    private final String resultName;

    public Prize(String resultName) {
        validate(resultName);
        this.resultName = resultName;
    }

    private void validate(String resultName) {
        validateNotBlank(resultName);
        validateResultNameLength(resultName);
        validateStripedResultName(resultName);
    }

    private void validateNotBlank(String resultName) {
        if (resultName == null || resultName.isBlank()) {
            throw new IllegalArgumentException("빈 값을 결과로 사용할 수 없습니다.");
        }
    }

    private void validateResultNameLength(String resultName) {
        if (resultName.length() > MAX_RESULT_LENGTH) {
            throw new IllegalArgumentException("결과는 " + MAX_RESULT_LENGTH + "자 이하로 구성되어야 합니다.");
        }
    }

    private void validateStripedResultName(String resultName) {
        if (!resultName.strip().equals(resultName)) {
            throw new IllegalArgumentException("앞, 뒤 공백이 존재하는 이름을 결과로 사용할 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Prize prize = (Prize) o;
        return Objects.equals(resultName, prize.resultName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resultName);
    }

    public String getPrizeName() {
        return resultName;
    }
}
