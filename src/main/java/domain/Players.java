package domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static message.ErrorMessage.*;

public class Players {

    private static final int MINIMUM_PLAYER_COUNT = 2;
    private final List<Player> players;

    public Players(List<Player> players) {
        validatePlayerSize(players);
        validateDuplicated(players);
        this.players = players;
    }

    private static void validatePlayerSize(List<Player> players) {
        if (players.size() < MINIMUM_PLAYER_COUNT) {
            throw new IllegalArgumentException(INVALID_PLAYER_COUNT_EXCEPTION.getMessageWithCause(players.size()));
        }
    }

    private static void validateDuplicated(List<Player> players) {
        Set<String> uniquePlayers = players.stream()
                .map(player -> player.getName())
                .collect(Collectors.toSet());

        if (players.size() != uniquePlayers.size()) {
            throw new IllegalArgumentException(DUPLICATED_PLAYER_NAME_EXCEPTION.getMessage());
        }
    }

    public Player findByName(String name) {
        return players.stream()
                .filter(player -> player.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_EXIST_PLAYER_NAME_EXCEPTION.getMessageWithCause(name)));
    }

    public List<String> getNames() {
        return players.stream()
                .map(player -> player.getName())
                .toList();
    }

    public int getWidth() {
        return players.size() - 1;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
