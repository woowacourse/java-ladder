package ladder.domain.result;

import java.util.HashMap;
import java.util.Map;

import ladder.domain.player.Player;
import ladder.domain.result.Result;

public class ResultByPlayer {

    private final Map<Player, Result> resultByPlayer;

    public ResultByPlayer(final Map<Player, Result> resultByPlayer) {
        this.resultByPlayer = new HashMap<>(resultByPlayer);
    }

    public Result findResultByPlayer(Player player) {
        Result findResult = resultByPlayer.get(player);
        return findResult;
    }

    public Map<Player, Result> findAll() {
        return Map.copyOf(resultByPlayer);
    }
}
