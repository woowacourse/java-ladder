package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    public static final int PLAYER_MIN_SIZE = 1;
    public static final int PLAYER_MAX_SIZE = 20;

    private final List<Player> players;

    public Players(final List<Player> players) {
        validate(players);
        this.players = new ArrayList<>(players);
    }

    private void validate(final List<Player> players) {
        validatePlayerSize(players);
        validateDuplication(players);
    }

    private void validatePlayerSize(final List<Player> players) {
        if (players.size() < PLAYER_MIN_SIZE || players.size() > PLAYER_MAX_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplication(final List<Player> players) {
        List<String> playerNames = players.stream()
                .map(Player::getName)
                .collect(Collectors.toUnmodifiableList());
        if (playerNames.size() != new HashSet<>(playerNames).size()) {
            throw new IllegalArgumentException();
        }
    }

    public List<String> getPlayerNames() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }
}
