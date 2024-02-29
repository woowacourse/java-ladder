package domain;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LadderGameResult {

    private final Map<Player, Result> ladderGameResult;

    public LadderGameResult(Ladder ladder, Players players, Results results) {
        ladderGameResult = players.getPlayers().stream()
                .collect(Collectors.toMap(Function.identity(),
                        player -> results.getResults().get(ladder.climb(player.getPosition()).getIndex())));
    }

    public Result get(Player player) {
        return ladderGameResult.get(player);
    }
}
