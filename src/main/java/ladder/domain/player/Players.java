package ladder.domain.player;

import static java.util.stream.Collectors.toUnmodifiableList;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Position;

public class Players {
    private static final int PLAYERS_SIZE_LOWER_BOUND = 2;
    private static final int PLAYERS_SIZE_UPPER_BOUND = 20;
    private static final String INVALID_PLAYERS_SIZE_MESSAGE =
            "참가자는 최소 " + PLAYERS_SIZE_LOWER_BOUND + "명, 최대 " + PLAYERS_SIZE_UPPER_BOUND + "명이어야 합니다.";
    private static final String DUPLICATE_NAMES_MESSAGE = "참가자의 이름은 중복되지 않아야 합니다.";
    private static final String INVALID_PLAYER_MESSAGE = "해당 위치에 있는 참가자가 존재하지 않습니다.";

    private final List<Player> players;

    private Players(final List<Player> players) {
        this.players = players;
    }

    public static Players from(final List<String> names) {
        validate(names);
        return IntStream.range(0, names.size())
                .mapToObj(index -> Player.of(names.get(index), index))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Players::new));
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

    public Map<Player, Position> play(final Ladder ladder) {
        final Map<Player, Position> result = new LinkedHashMap<>();
        for (Player player : players) {
            result.put(player, player.play(ladder));
        }
        return result;
    }

    public Player findByPosition(final Position position) {
        return players.stream()
                .filter(player -> player.isSamePosition(position))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_PLAYER_MESSAGE));
    }

    public int count() {
        return players.size();
    }

    public List<String> getNames() {
        return players.stream()
                .map(Player::getName)
                .collect(toUnmodifiableList());
    }
}
