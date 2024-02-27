package domain;

import java.util.HashMap;
import java.util.Map;

public class LadderGameResult {

    private final Map<Player, Result> ladderGameResult;

    public LadderGameResult(Ladder ladder, Players players, Results results) {
        ladderGameResult = new HashMap<>();
        for (int i = 0; i < players.getPlayers().size(); i++) {
            ladderGameResult.put(players.getPlayers().get(i), results.getResults().get(ladder.climb(i)));
        }
    }

    public Result get(Player player) {
        return ladderGameResult.get(player);
    }
}
