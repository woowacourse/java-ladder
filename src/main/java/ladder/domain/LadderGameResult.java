package ladder.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGameResult {
    private static final String MULTIPLE_RESULT_RESERVED_NAME = "all";
    private static final String INVALID_PLAYER_MESSAGE = "사다리 게임에 참가한 사람의 이름을 입력해야합니다.";

    private final Map<Player, Item> result;

    public LadderGameResult(final Map<Player, Item> result) {
        this.result = result;
    }

    public Map<String, String> get(final String name) {
        if (MULTIPLE_RESULT_RESERVED_NAME.equals(name)) {
            return getMultipleResult();
        }
        return getSingleResult(name);
    }

    private Map<String, String> getMultipleResult() {
        final Map<String, String> playerToItem = new LinkedHashMap<>();
        for (Player player : result.keySet()) {
            playerToItem.put(player.getName(), getItemName(player));
        }
        return playerToItem;
    }

    private String getItemName(final Player player) {
        return result.get(player).getName();
    }

    private Map<String, String> getSingleResult(final String name) {
        final Player player = new Player(name);
        if (!result.containsKey(player)) {
            throw new IllegalArgumentException(INVALID_PLAYER_MESSAGE);
        }
        final Item item = result.get(player);
        return Map.of(player.getName(), item.getName());
    }
}
