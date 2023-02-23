package ladder.domain;

import static java.util.stream.Collectors.toUnmodifiableList;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Players {
    private static final int PLAYERS_SIZE_LOWER_BOUND = 2;
    private static final int PLAYERS_SIZE_UPPER_BOUND = 20;
    private static final String INVALID_PLAYERS_SIZE_MESSAGE =
            "참가자는 최소 " + PLAYERS_SIZE_LOWER_BOUND + "명, 최대 " + PLAYERS_SIZE_UPPER_BOUND + "명이어야 합니다.";
    private static final String DUPLICATE_NAMES_MESSAGE = "참가자의 이름은 중복되지 않아야 합니다.";

    private final Map<Position, Player> players;

    private Players(final Map<Position, Player> players) {
        this.players = players;
    }

    public static Players from(final List<String> names) {
        validate(names);
        final Map<Position, Player> players = new LinkedHashMap<>();
        for (int index = 0; index < names.size(); index++) {
            players.put(Position.valueOf(index), new Player(names.get(index)));
        }
        return new Players(players);
    }

    private static void validate(final List<String> names) {
        validatePlayersSize(names);
        validateDuplicateNames(names);
    }

    private static void validatePlayersSize(final List<String> names) {
        if (names.size() < PLAYERS_SIZE_LOWER_BOUND || PLAYERS_SIZE_UPPER_BOUND < names.size()) {
            throw new IllegalArgumentException(INVALID_PLAYERS_SIZE_MESSAGE);
        }
    }

    private static void validateDuplicateNames(final List<String> names) {
        final Set<String> nonDuplicateNames = new HashSet<>(names);
        if (nonDuplicateNames.size() != names.size()) {
            throw new IllegalArgumentException(DUPLICATE_NAMES_MESSAGE);
        }
    }

    public int count() {
        return players.size();
    }

    public Player get(final Position position) {
        return players.get(position);
    }

    public List<String> getNames() {
        return players.values().stream()
                .map(Player::getName)
                .collect(toUnmodifiableList());
    }
}
