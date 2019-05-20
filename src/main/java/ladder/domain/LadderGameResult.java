package ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGameResult {
    private final Map<PlayerName, Result> gameResult = new HashMap<>();

    public LadderGameResult(Players players, Results results) {
        List<Result> resultList = results.getResults();

        for (Player player : players.getPlayers()) {
            gameResult.put(player.getName(), resultList.get(player.getPosition()));
        }
    }

    public Map<PlayerName, Result> getGameResult() {
        return gameResult;
    }
}
