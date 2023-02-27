package domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class MatchingResult {

    private final Map<Player, Result> matchingResult;

    public MatchingResult(Map<Player, Result> matchingResult) {
        this.matchingResult = matchingResult;
    }

    public Map<Player, Result> getFinalResult(Players players, String[] matchingNames) {
        if (getAllResult(matchingNames)) return Map.copyOf(matchingResult);

        Map<Player, Result> finalMatchingResult = new LinkedHashMap<>();
        for (String matchingName : matchingNames) {
            Player player = players.findPlayer(matchingName);
            Result result = matchingResult.get(player);
            finalMatchingResult.put(player, result);
        }
        return finalMatchingResult;
    }

    private boolean getAllResult(String[] matchingNames) {
        return matchingNames[0].equals("all");
    }

    public Map<Player, Result> getMatchingResult() {
        return matchingResult;
    }
}
