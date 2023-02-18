package ladder.domain;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toUnmodifiableList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Players {
    private static final int PLAYERS_SIZE_LOWER_BOUND = 2;
    private static final String INVALID_PLAYERS_SIZE_MESSAGE = "참가자는 최소 " + PLAYERS_SIZE_LOWER_BOUND + "명이어야 합니다.";
    private static final String DUPLICATE_NAMES_MESSAGE = "참가자의 이름은 중복되지 않아야 합니다.";

    private final List<Player> players;

    private Players(final List<Player> players) {
        this.players = players;
    }

    public static Players from(final List<String> names) {
        validate(names);
        return new Players(toPlayers(names));
    }

    private static void validate(final List<String> names) {
        validatePlayersSize(names);
        validateDuplicateNames(names);
    }

    private static void validatePlayersSize(final List<String> names) {
        if (names.size() < PLAYERS_SIZE_LOWER_BOUND) {
            throw new IllegalArgumentException(INVALID_PLAYERS_SIZE_MESSAGE);
        }
    }

    private static void validateDuplicateNames(final List<String> names) {
        final Set<String> nonDuplicateNames = new HashSet<>(names);
        if (nonDuplicateNames.size() != names.size()) {
            throw new IllegalArgumentException(DUPLICATE_NAMES_MESSAGE);
        }
    }

    private static List<Player> toPlayers(final List<String> names) {
        return names.stream()
                .map(Player::new)
                .collect(toList());
    }

    public List<String> getNames() {
        return players.stream()
                .map(Player::getName)
                .collect(toUnmodifiableList());
    }

    public int count() {
        return players.size();
    }
}
