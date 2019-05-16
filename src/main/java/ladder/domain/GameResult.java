package ladder.domain;

import java.util.Map;
import java.util.Objects;

public final class GameResult {
    private final Map<Integer, String> results;

    public GameResult(final Map<Integer, String> results) {
        validateSize(results);
        this.results = results;
    }

    private void validateSize(Map<Integer, String> results) {
        if (results.isEmpty()) {
            throw new IllegalArgumentException("결과를 1개 이상 입력해 주세요");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResult that = (GameResult) o;
        return Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }
}
