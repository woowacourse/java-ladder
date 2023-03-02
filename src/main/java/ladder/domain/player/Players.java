package ladder.domain.player;

import ladder.domain.player.exception.DuplicatePlayerNameException;
import ladder.domain.player.exception.NoSuchPlayerException;
import ladder.domain.player.exception.PlayerNumberException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private static final int PLAYER_MINIMUM_NUMBER = 2;

    private final List<Player> players;

    private Players(final List<Player> players) {
        this.players = players;
    }

    public static Players from(final List<String> playerNames) {
        validatePlayerNumber(playerNames);
        validateDuplicatedPlayer(playerNames);
        List<Player> players = new ArrayList<>();
        int playerPosition = 0;
        for (String playerName : playerNames) {
            players.add(Player.of(playerName, playerPosition++));
        }
        return new Players(players);
    }

    private static void validatePlayerNumber(final List<String> playerNames) {
        if (playerNames.size() < PLAYER_MINIMUM_NUMBER) {
            throw new PlayerNumberException();
        }
    }

    private static void validateDuplicatedPlayer(final List<String> playerNames) {
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

    public Player findByName(final String name) {
        return players.stream()
                .filter(player -> player.getPlayerName().getName().equals(name))
                .findFirst()
                .orElseThrow(NoSuchPlayerException::new);
    }

    public int size() {
        return players.size();
    }
}
