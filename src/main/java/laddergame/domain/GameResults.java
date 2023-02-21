package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class GameResults {

    private final List<GameResult> results;

    public GameResults(List<GameResult> gameResults, int userCount) {
        validateGameResults(gameResults, userCount);
        
        results = new ArrayList<>();
        addResult(gameResults);
    }

    private void validateGameResults(List<GameResult> results, int userCount) {
        if (results.size() != userCount) {
            throw new IllegalArgumentException();
        }
    }

    private void addResult(List<GameResult> gameResults) {
        results.addAll(gameResults);
    }

    public List<GameResult> getResults() {
        return results;
    }
}
