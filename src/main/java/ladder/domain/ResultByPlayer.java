package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class ResultByPlayer {

    private final Map<Player, Result> resultByPlayer;

    public ResultByPlayer(final Map<Player, Result> resultByPlayer) {
        this.resultByPlayer = new HashMap<>(resultByPlayer);
    }

    public Result findResultByPlayer(Player player) {
        return resultByPlayer.get(player);
    }
}
