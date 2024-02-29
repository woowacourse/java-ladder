package laddergame.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class PlayersResult {
    private static final String NO_FIND_PLAYER = "존재하지 않는 이름입니다.";
    private final LinkedHashMap<Player, ResultItem> allResult = new LinkedHashMap<>();

    public void addResult(Player player, ResultItem item) {
        allResult.put(player, item);
    }

    public ResultItem findItemByPlayerName(String name) {
        for (Player player : allResult.keySet()) {
            if (player.getName().equals(name)) {
                return allResult.get(player);
            }
        }
        throw new IllegalArgumentException(NO_FIND_PLAYER);
    }

    public Map<Player, ResultItem> getAllResult() {
        return allResult;
    }
}
