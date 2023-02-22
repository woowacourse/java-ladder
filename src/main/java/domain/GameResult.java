package domain;

import java.util.Map;

public class GameResult {

    private final Map<String, String> gameResult;

    public GameResult(final Map<String, String> gameResult) {
        this.gameResult = gameResult;
    }

    public String findResult(final String name) {
        if (name.equals("all")) {
            return String.join(",", this.gameResult.values());
        }
        return this.gameResult.get(name);
    }

    public Map<String, String> getGameResult() {
        return this.gameResult;
    }
}
