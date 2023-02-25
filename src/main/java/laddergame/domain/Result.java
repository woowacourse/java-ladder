package laddergame.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {

    private final Map<String, String> result;

    public Result(Players players, Ladder ladder, Prizes prizes) {
        this.result = makeResult(players, ladder, prizes);
    }

    private Map<String, String> makeResult(Players players, Ladder ladder, Prizes prizes) {
        final Map<String, String> result = new HashMap<>();
        final List<String> playerNames = players.getPlayerNames();
        for (int playerPosition = 0; playerPosition < players.size(); playerPosition++) {
            final int prizePosition = ladder.climb(playerPosition);
            result.put(playerNames.get(playerPosition), prizes.get(prizePosition));
        }
        return result;
    }

    public String getResult(String playerName) {
        hasPlayerName(playerName);
        return result.get(playerName);
    }

    private void hasPlayerName(String playerName) {
        if (!result.containsKey(playerName)) {
            throw new IllegalArgumentException("[ERROR] 해당하는 플레이어 이름이 없습니다. 재입력해주세요.");
        }
    }

    public Map<String, String> getAllResults() {
        return Collections.unmodifiableMap(result);
    }
}
