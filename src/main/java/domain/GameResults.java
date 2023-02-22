package domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class GameResults {

    private final List<GameResult> gameResults;

    public GameResults(int playerSize, List<GameResult> gameResults) {
        validate(playerSize, gameResults);
        this.gameResults = Collections.unmodifiableList(gameResults);
    }

    private void validate(int playerSize, List<GameResult> gameResults) {
        validateNullAndEmpty(gameResults);
        validateSize(playerSize, gameResults);
    }

    private void validateNullAndEmpty(List<GameResult> results) {
        if (Objects.isNull(results) || results.isEmpty()) {
            throw new IllegalArgumentException("실행 결과를 입력하세요.");
        }
    }

    private static void validateSize(int playerSize, List<GameResult> results) {
        if (results.size() != playerSize) {
            throw new IllegalArgumentException("실행 결과 개수는 플레이어 수와 일치해야 합니다.");
        }
    }

    public List<GameResult> getGameResults() {
        return gameResults;
    }

    public GameResult getGameResultAt(int order) {
        return gameResults.get(order - 1);
    }
}
