package ladder.domain;

import ladder.exception.PlayerNumberException;

import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private static final int PLAYER_MINIMUM_NUMBER = 2;

    private final List<Player> players;

    public Players(List<String> playerNames) {
        validatePlayerNumber(playerNames);

        players = playerNames.stream()
                .map(Player::new)
                .collect(Collectors.toUnmodifiableList());
    }

    private void validatePlayerNumber(List<String> playerNames) {
        if (playerNames.size() < PLAYER_MINIMUM_NUMBER) {
            throw new PlayerNumberException();
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int size() {
        return players.size();
    }
}
