package domain;

import java.util.List;
import java.util.Map;

public class LadderResult {

    private Map<String, String> results;

    public LadderResult(Map<String, String> results) {
        this.results = results;
    }

    public List<String> getWinning(String player) {
        Name name = new Name(player);
        return List.of(results.get(player));
    }
}
