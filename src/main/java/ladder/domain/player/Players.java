package ladder.domain.player;

import ladder.exception.PlayerNumberException;

import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private static final int PLAYER_MINIMUM_NUMBER = 2;

    private final List<Player> players;

    public Players(final List<String> playerNames) {
        validatePlayerNumber(playerNames);
        players = mapPlayerNamesToPlayers(playerNames);
    }

    private void validatePlayerNumber(final List<String> playerNames) {
        if (playerNames.size() < PLAYER_MINIMUM_NUMBER) {
            throw new PlayerNumberException();
        }
    }

    private List<Player> mapPlayerNamesToPlayers(List<String> playerNames) {
        return playerNames.stream()
                .map(Player::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Player> getPlayers() {
        return List.copyOf(players);
    }

    public int size() {
        return players.size();
    }
}
