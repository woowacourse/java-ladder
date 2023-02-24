package laddergame.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {

    private final Map<String, String> result;

    public Result(Players players, Ladder ladder, Prizes prizes) {
        this.result = makeResult(players, ladder, prizes);
    }

    public Map<String, String> makeResult(Players players, Ladder ladder, Prizes prizes) {
        final Map<String, String> result = new HashMap<>();
        final List<String> playerNames = players.getPlayerNames();
        for (int playerPosition = 0; playerPosition < players.size(); playerPosition++) {
            final int prizePosition = ladder.climb(playerPosition);
            result.put(playerNames.get(playerPosition), prizes.get(prizePosition));
        }
        return result;
    }
}
