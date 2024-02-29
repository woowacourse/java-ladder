package domain;

import java.util.HashMap;
import java.util.Map;

public class LadderGameResult {

    private final Map<Player, Result> ladderGameResult;

    public LadderGameResult(Ladder ladder, Players players, Results results) {
        ladderGameResult = new HashMap<>();
        players.getPlayers().stream()
                .forEach(
                        player -> ladderGameResult.put(player,
                                results.getResults().get(ladder.climb(new Position(players.getPlayers().indexOf(player))).getIndex()))
                );
    }

    public Result get(Player player) {
        return ladderGameResult.get(player);
    }
}
