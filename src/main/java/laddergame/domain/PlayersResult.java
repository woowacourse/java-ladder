package laddergame.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PlayersResult {
    private static final String NO_FIND_PLAYER = "존재하지 않는 플레이어입니다.";

    private final Map<Player, ResultItem> allResult;

    public PlayersResult(Map<Player, ResultItem> allResult) {
        this.allResult = allResult;
    }

    public ResultItem findItemByName(String name) {
        return allResult.keySet().stream()
                .filter(player -> player.getName().equals(name))
                .findFirst()
                .map(allResult::get)
                .orElseThrow(() -> new IllegalArgumentException(NO_FIND_PLAYER));
    }

    public Map<Player, ResultItem> getAllResult() {
        return Collections.unmodifiableMap(allResult);
    }
}
