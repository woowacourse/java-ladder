package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class GameResults {

    private final List<GameResult> results;

    public GameResults(List<String> resultInput, int userCount) {
        validateGameResults(resultInput, userCount);
        
        results = new ArrayList<>();
        addResult(resultInput);
    }

    private void validateGameResults(List<String> results, int userCount) {
        if (results.size() != userCount) {
            throw new IllegalArgumentException();
        }
    }

    private void addResult(List<String> resultInput) {
        for (String result : resultInput) {
            results.add(new GameResult(result));
        }
    }

    public List<GameResult> getResults() {
        return results;
    }
}
