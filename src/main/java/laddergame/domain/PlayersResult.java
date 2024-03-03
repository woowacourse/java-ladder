package laddergame.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class PlayersResult {
    private static final String NO_FIND_PLAYER = "존재하지 않는 플레이어입니다.";
    private final LinkedHashMap<Player, ResultItem> allResult = new LinkedHashMap<>();

    public void addResult(Player player, ResultItem item) {
        allResult.put(player, item);
    }

    public ResultItem findItemByName(String name) {
        return allResult.keySet().stream()
                .filter(player -> player.getName().equals(name))
                .findFirst()
                .map(allResult::get)
                .orElseThrow(() -> new IllegalArgumentException(NO_FIND_PLAYER));
    }

    public Map<Player, ResultItem> getAllResult() {
        return allResult;
    }
}
