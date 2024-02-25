package model.player;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Players {
    private static final int MIN_SIZE_OF_PLAYERS = 2;
    private static final String INVALID_SIZE_OF_PLAYERS = "참여자 수는 최소 2명입니다.";
    private static final String INVALID_PLAYER_NAMES_UNIQUE = "참여자 이름은 중복될 수 없습니다.";

    private final List<Player> players;

    private Players(List<Player> players) {
        validate(players);
        this.players = players;
    }

    private void validate(List<Player> players) {
        validateSizeOfPlayers(players);
        validatePlayerNamesUnique(players);
    }

    private void validateSizeOfPlayers(List<Player> players) {
        if (players.size() < MIN_SIZE_OF_PLAYERS) {
            throw new IllegalArgumentException(INVALID_SIZE_OF_PLAYERS);
        }
    }

    private void validatePlayerNamesUnique(List<Player> players) {
        Set<Player> uniquePlayers = new HashSet<>(players);
        if (uniquePlayers.size() < players.size()) {
            throw new IllegalArgumentException(INVALID_PLAYER_NAMES_UNIQUE);
        }
    }

    public static Players from(List<String> names) {
        return names.stream()
                .map(Player::new)
                .collect(collectingAndThen(toList(), Players::new));
    }

    public List<String> getPlayerNames() {
        return players.stream()
                .map(Player::name)
                .toList();
    }

    public int getSizeOfPlayers() {
        return players.size();
    }
}
