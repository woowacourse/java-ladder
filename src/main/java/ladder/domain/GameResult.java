package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class GameResult {
    private final Map<String, String> results;

    public GameResult(final Map<String, String> results) {
        this.results = results;
    }

    public String get(String playerName) {
        return results.get(playerName);
    }

    public Map<String, String> getAll() {
        return new HashMap<>(results);
    }
}
