package domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class GameResults {

    private final List<GameResult> gameResults;

    public GameResults(final List<GameResult> gameResults) {
        validateNullAndEmpty(gameResults);
        this.gameResults = Collections.unmodifiableList(gameResults);
    }

    private void validateNullAndEmpty(final List<GameResult> results) {
        if (Objects.isNull(results) || results.isEmpty()) {
            throw new IllegalArgumentException("실행 결과를 입력하세요.");
        }
    }

    public List<GameResult> getGameResults() {
        return gameResults;
    }

    public GameResult getGameResultAt(final int order) {
        return gameResults.get(order);
    }

    public GameResult getGameResultOf(Player player) {
        return gameResults.stream()
                .filter(gameResult -> gameResult.getPlayer().equals(player))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 플레이어입니다."));
    }
}
