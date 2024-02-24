package laddergame.domain;

import static laddergame.domain.Player.NAME_BLANK_ERROR;

import java.util.List;

public class Players {
    private static final String NAME_DUPLICATED_ERROR = "이름의 중복은 허용하지 않습니다.";
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
    }

    private static void checkDuplicated(List<String> playerNames) {
        if (hasDuplicateName(playerNames)) {
            throw new IllegalArgumentException(NAME_DUPLICATED_ERROR);
        }
    }

    private static void checkBlankName(List<String> playerNames) {
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

    public List<Player> getPlayers() {
        return players;
    }
}
