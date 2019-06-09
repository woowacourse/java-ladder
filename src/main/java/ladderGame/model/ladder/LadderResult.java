package ladderGame.model.ladder;

import java.util.*;

public class LadderResult {
    Map<String, String> result;

    public LadderResult(Ladder ladder, List<String> players, List<String> results) {
        result = new HashMap<>();
        for (int i = 0; i < players.size(); i++) {
            result.put(players.get(i), results.get(ladder.getArrivialIndex(i)));
        }
    }

    public Map<String, String> getAllResult() {
        return Collections.unmodifiableMap(result);
    }

    public Set<String> getPlayers() {
        return result.keySet();
    }
}
