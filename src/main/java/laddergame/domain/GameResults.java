package laddergame.domain;

import static laddergame.utils.ErrorMessage.INVALID_GAME_RESULTS_SIZE;

import java.util.ArrayList;
import java.util.List;

public class GameResults {
    private static final int FIRST = 0;

    private final List<GameResult> results;

    public GameResults(List<GameResult> gameResults, int userCount) {
        validateGameResults(gameResults, userCount);
        
        results = new ArrayList<>();
        addResult(gameResults);
    }

    public int size() {
        return results.size();
    }

    private void validateGameResults(List<GameResult> results, int userCount) {
        if (results.size() != userCount) {
            throw new IllegalArgumentException(INVALID_GAME_RESULTS_SIZE.getMessage());
        }
    }

    private void addResult(List<GameResult> gameResults) {
        results.addAll(gameResults);
    }

    public List<GameResult> getResults() {
        return results;
    }

    public String getFirstResult() {
        return results.get(FIRST).getResult();
    }
}
