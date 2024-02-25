package laddergame.domain;

import laddergame.domain.move.Trace;
import laddergame.domain.player.Player;

import java.util.Map;

public class Result {
    private Map<Player, Trace> result;

    public Result(final Map<Player, Trace> result) {
        this.result = result;
    }

    public Map<Player, Trace> getResult() {
        return result;
    }
}
