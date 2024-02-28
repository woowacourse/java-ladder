package domain;

import java.util.HashMap;
import java.util.Map;

public class LadderGameResult {

    private final Map<Player, Result> ladderGameResult;

    public LadderGameResult(Ladder ladder, Players players, Results results) {
        ladderGameResult = new HashMap<>();

        players.getPlayers().stream()
                .forEach(
                        player -> ladderGameResult.put(player, results.getResults().get(players.getPlayers().indexOf(player)))
                );
    }

    public Result get(Player player) {
        return ladderGameResult.get(player);
    }
}
