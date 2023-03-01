package domain;

import java.util.Map;

public class MatchingResult {

    private final Map<Player, Result> matchingResult;

    public MatchingResult(Map<Player, Result> matchingResult) {
        this.matchingResult = matchingResult;
    }

    public Map<Player, Result> getMatchingResult() {
        return matchingResult;
    }
}
