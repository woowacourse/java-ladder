package ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGameResult {
    private static final String VIOLATE_NO_RESULT = "게임 참가자가 아닙니다.";

    private final Map<PlayerName, Result> gameResult = new HashMap<>();

    public LadderGameResult(Players players, Results results) {
        List<Result> resultList = results.getResults();

        for (Player player : players.getPlayers()) {
            gameResult.put(player.getName(), resultList.get(player.getPosition()));
        }
    }

    public Result getResult(PlayerName name) {
        if (gameResult.get(name) == null) {
            throw new IllegalArgumentException(VIOLATE_NO_RESULT);
        }
        return gameResult.get(name);
    }

    public Map<PlayerName, Result> getGameResult() {
        return gameResult;
    }
}
