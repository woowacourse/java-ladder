package laddergame.domain;

import static laddergame.domain.Player.NAME_BLANK_ERROR;

import java.util.List;

public class Players {
    private static final String NAME_DUPLICATED_ERROR = "이름의 중복은 허용하지 않습니다.";
    public static final String PLAYER_NOT_FOUND_ERROR = "%s 플레이어를 찾을 수 없습니다.";
    private static final String INVALID_PLAYERS_RANGE = "플레이어 수는 반드시 2명 이상, 9명 이하로 이루어져야 합니다. 입력된 플레이어 수는 %d 명 입니다.";
    private static final int MAX_PLAYER_COUNT = 9;
    private static final int MIN_PLAYER_COUNT = 2;
    private final List<Player> players;

    private Players(final List<Player> players) {
        this.players = players;
    }

    public static Players from(final List<String> playerNames) {
        validate(playerNames);

        return new Players(playerNames.stream()
                .map(Player::new)
                .toList()
        );
    }

    private static void validate(final List<String> playerNames) {
        checkBlankName(playerNames);
        checkDuplicated(playerNames);
        checkPlayerCounts(playerNames);
    }

    private static void checkPlayerCounts(final List<String> playerNames) {
        if (playerNames.size() < MIN_PLAYER_COUNT || playerNames.size() > MAX_PLAYER_COUNT) {
            throw new IllegalArgumentException(String.format(INVALID_PLAYERS_RANGE, playerNames.size()));
        }
    }

    private static void checkDuplicated(final List<String> playerNames) {
        if (hasDuplicateName(playerNames)) {
            throw new IllegalArgumentException(NAME_DUPLICATED_ERROR);
        }
    }

    private static void checkBlankName(final List<String> playerNames) {
        if (playerNames.stream().anyMatch(String::isBlank)) {
            throw new IllegalArgumentException(NAME_BLANK_ERROR);
        }
    }

    private static boolean hasDuplicateName(final List<String> carNames) {
        return carNames.size() != getDistinctNamesCount(carNames);
    }

    private static long getDistinctNamesCount(final List<String> playerNames) {
        return playerNames.stream()
                .distinct()
                .count();
    }

    public boolean isIncluded(final String name) {
        return players.stream()
                .anyMatch(player -> player.getName().equals(name));
    }

    public Player getPlayerByName(final String name) {
        return players.stream()
                .filter(player -> player.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format(PLAYER_NOT_FOUND_ERROR, name)));
    }

    public int getPlayersSize() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return players;
    }
}
