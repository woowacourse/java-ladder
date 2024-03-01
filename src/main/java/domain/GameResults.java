package domain;

import java.util.List;
import java.util.Objects;

public class GameResults {

    private static final int ONLY_ONE_FOUND = 1;

    private final List<GameResult> gameResults;

    public GameResults(final List<GameResult> gameResults) {
        this.gameResults = gameResults;
    }

    public GameResult findByName(final String name) {
        final List<GameResult> gameResultFound = gameResults.stream()
                .filter(gameResult -> Objects.equals(gameResult.name(), name))
                .toList();
        if (gameResultFound.size() != ONLY_ONE_FOUND) {
            throw new IllegalArgumentException("해당 이름의 참가자가 없거나 이름이 중복됩니다.");
        }
        return gameResultFound.get(0);
    }

    public GameResult findByIndex(final int index) {
        return gameResults.get(index);
    }

    public int count() {
        return gameResults.size();
    }
}
