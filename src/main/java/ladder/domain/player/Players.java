package ladder.domain.player;

import ladder.domain.player.exception.PlayerNumberException;

import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private static final int PLAYER_MINIMUM_NUMBER = 2;

    private final List<PlayerName> players;

    public Players(final List<String> playerNames) {
        validatePlayerNumber(playerNames);

        players = playerNames.stream()
                .map(PlayerName::new)
                .collect(Collectors.toUnmodifiableList());
    }

    private void validatePlayerNumber(final List<String> playerNames) {
        if (playerNames.size() < PLAYER_MINIMUM_NUMBER) {
            throw new PlayerNumberException();
        }
    }

    public List<PlayerName> getPlayers() {
        return List.copyOf(players);
    }

    public int size() {
        return players.size();
    }
}
