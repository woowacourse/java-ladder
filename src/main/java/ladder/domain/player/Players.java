package ladder.domain.player;

import ladder.domain.player.exception.DuplicatePlayerNameException;
import ladder.domain.player.exception.NoSuchPlayerException;
import ladder.domain.player.exception.PlayerNumberException;

import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private static final int PLAYER_MINIMUM_NUMBER = 2;

    private final List<Player> players;

    public Players(final List<String> playerNames) {
        validatePlayerNumber(playerNames);
        validateDuplicatedPlayer(playerNames);

        players = playerNames.stream()
                .map(playerName -> Player.of(playerName, 0))
                .collect(Collectors.toUnmodifiableList());
    }

    private void validatePlayerNumber(final List<String> playerNames) {
        if (playerNames.size() < PLAYER_MINIMUM_NUMBER) {
            throw new PlayerNumberException();
        }
    }

    private void validateDuplicatedPlayer(final List<String> playerNames) {
        List<String> distinctPlayerNames = playerNames.stream()
                .distinct()
                .collect(Collectors.toUnmodifiableList());
        if (distinctPlayerNames.size() != playerNames.size()) {
            throw new DuplicatePlayerNameException();
        }
    }

    public List<Player> getPlayers() {
        return List.copyOf(players);
    }

    public Player findByName(String name) {
        return players.stream()
                .filter(player -> player.getPlayerName().getName().equals(name))
                .findFirst()
                .orElseThrow(NoSuchPlayerException::new);
    }

    public int size() {
        return players.size();
    }
}
