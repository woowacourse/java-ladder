package laddergame.domain;

import laddergame.domain.move.Trace;
import laddergame.domain.player.Player;
import laddergame.domain.target.Target;

import java.util.Map;

public class Result {
    private Map<Player, Target> result;

    public Result(final Map<Player, Target> result) {
        this.result = result;
    }

    public Map<Player, Target> getResult() {
        return result;
    }
}
