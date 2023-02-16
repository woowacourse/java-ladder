package ladder.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Players {
    private static final int PLAYERS_SIZE_LOWER_BOUND = 2;
    private static final String INVALID_PLAYERS_SIZE_MESSAGE = "참가자는 최소 " + PLAYERS_SIZE_LOWER_BOUND + "명이어야 합니다.";
    private static final String DUPLICATE_NAMES_MESSAGE = "참가자의 이름은 중복되지 않아야 합니다.";

    private final List<Player> players;

    public Players(final List<String> names) {
        validate(names);
        this.players = generatePlayers(names);
    }

    private void validate(final List<String> names) {
        validatePlayersSize(names);
        validateDuplicateNames(names);
    }

    private void validatePlayersSize(final List<String> names) {
        if (names.size() < PLAYERS_SIZE_LOWER_BOUND) {
            throw new IllegalArgumentException(INVALID_PLAYERS_SIZE_MESSAGE);
        }
    }

    private void validateDuplicateNames(final List<String> names) {
        final Set<String> nonDuplicateNames = new HashSet<>(names);
        if (nonDuplicateNames.size() != names.size()) {
            throw new IllegalArgumentException(DUPLICATE_NAMES_MESSAGE);
        }
    }

    private List<Player> generatePlayers(final List<String> names) {
        return names.stream()
                .map(Player::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<String> getNames() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    public int count() {
        return players.size();
    }
}
