package ladder.domain;

import static java.util.stream.Collectors.toMap;

import java.util.Map;

class LadderGameResult {

    private static final String PRINT_ALL = "all";
    private static final String INVALID_PLAYER_MESSAGE = "사다리 게임에 참가한 사람의 이름을 입력해야합니다.";

    private final Map<Player, Item> result;

    public LadderGameResult(final Map<Player, Item> result) {
        this.result = result;
    }

    public Map<String, String> get(final String name) {
        if (name.equals(PRINT_ALL)) {
            return getAll();
        }
        return getSingle(name);
    }

    private Map<String, String> getAll() {
        return result.keySet().stream()
                .collect(toMap(Player::getName, this::getItemName));
    }

    private String getItemName(final Player player) {
        return result.get(player).getName();
    }

    private Map<String, String> getSingle(final String name) {
        final Player player = new Player(name);
        if (!result.containsKey(player)) {
            throw new IllegalArgumentException(INVALID_PLAYER_MESSAGE);
        }
        final Item item = result.get(player);
        return Map.of(player.getName(), item.getName());
    }
}
