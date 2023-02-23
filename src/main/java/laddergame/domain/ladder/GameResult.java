package laddergame.domain.ladder;

import java.util.LinkedHashMap;
import java.util.Map;

public class GameResult {

    private final Map<String, String> result;

    public GameResult(Map<String, String> result) {
        this.result = result;
    }

    public String findByPlayerName(String name) {
        return result.get(name);
    }

    public Map<String, String> result() {
        return new LinkedHashMap<>(result);
    }
}
