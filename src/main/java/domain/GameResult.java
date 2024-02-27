package domain;

import java.util.Objects;

public class GameResult {

    private final String name;

    public GameResult(String resultName) {
        validateNameLength(resultName);

        this.name = resultName;
    }

    private void validateNameLength(String resultName) {
        if (resultName.trim().isEmpty()) {
            throw new IllegalArgumentException("실행 결과는 공백을 제외한 1자 이상 입력해주세요.");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResult result = (GameResult) o;
        return Objects.equals(name, result.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
