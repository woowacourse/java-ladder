package ladder.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Players {

    private static final int MINIMUM_PLAYER_SIZE = 2;
    private static final int MAXIMUM_PLAYER_SIZE = 10;

    private final List<Player> players;

    public Players(final List<Player> players) {
        validate(players);
        this.players = players;
    }

    public static Players from(final List<String> names) {
        return new Players(generatePlayers(names));
    }

    private static List<Player> generatePlayers(final List<String> names) {
        return names.stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }

    private void validate(final List<Player> players) {
        validateSize(players);
        validateDuplicatePlayer(players);
    }

    private void validateSize(final List<Player> players) {
        if (isInvalidSize(players)) {
            throw new IllegalArgumentException(
                    "플레이어는 " + MINIMUM_PLAYER_SIZE + "명 이상, " + MAXIMUM_PLAYER_SIZE + "명 이하만 가능합니다."
                            + " 현재 입력한 플레이어 수는 " + players.size() + "명 입니다.");
        }
    }

    private boolean isInvalidSize(final List<Player> players) {
        return players.size() < MINIMUM_PLAYER_SIZE || MAXIMUM_PLAYER_SIZE < players.size();
    }

    private void validateDuplicatePlayer(final List<Player> players) {
        final Set<Player> uniquePlayers = new HashSet<>(players);

        if (players.size() != uniquePlayers.size()) {
            throw new IllegalArgumentException("플레이어 이름은 중복되면 안됩니다.");
        }
    }

    public List<String> getPlayerNames() {
        return players.stream()
                .map(Player::getValue)
                .collect(Collectors.toUnmodifiableList());
    }

    public int size() {
        return players.size();
    }
}
