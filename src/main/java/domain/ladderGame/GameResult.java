package domain.ladderGame;

import java.util.LinkedHashMap;

public class GameResult {

    private final LinkedHashMap<String, String> results;

    public GameResult(LinkedHashMap<String, String> results) {
        this.results = results;
    }

    public LinkedHashMap<String, String> getResults() {
        return results;
    }
}
