package ladder.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGameResult {
    static final String INVALID_PLAYER_MESSAGE = "사다리 게임에 참가한 사람의 이름을 입력해야합니다.";
    private static final String MULTIPLE_RESULT_RESERVED_NAME = "all";

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
            playerToItem.put(player.getName(), findItemName(player));
        }
        return playerToItem;
    }

    private String findItemName(final Player player) {
        return result.get(player).getName();
    }

    private Map<String, String> getSingleResult(final String name) {
        final Player player = findPlayer(name);
        final Item item = result.get(player);
        return Map.of(player.getName(), item.getName());
    }

    private Player findPlayer(final String name) {
        return result.keySet().stream()
                .filter(player -> player.isSameName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_PLAYER_MESSAGE));
    }

    public void validatePlayerName(final String name) {
        if (isInvalidPlayerName(name) && isNotReservedName(name)) {
            throw new IllegalArgumentException(INVALID_PLAYER_MESSAGE);
        }
    }

    private boolean isInvalidPlayerName(final String name) {
        return this.result.keySet().stream()
                .noneMatch(player -> player.isSameName(name));
    }

    private boolean isNotReservedName(final String name) {
        return !MULTIPLE_RESULT_RESERVED_NAME.equals(name);
    }
}
