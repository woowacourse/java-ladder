package laddergame.domain;

import laddergame.constant.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Players {

    private static final int MIN_PLAYER_COUNT = 2;
    
    private final List<Player> players;

    public Players(List<String> playerNames) {
        List<Player> players = playerNames.stream()
                .map(name -> new Player(name))
                .collect(Collectors.toUnmodifiableList());
        validatePlayerNames(players);
        this.players = List.copyOf(players);
    }

    private void validatePlayerNames(List<Player> players) {
        Set<Player> playerSet = new HashSet<>(players);
        if (playerSet.size() != players.size()) {
            throw new IllegalArgumentException(ErrorMessage.PLAYER_NAME_DUPLICATED.getMessage());
        }

        if (players.size() < MIN_PLAYER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.NOT_VALID_PLAYER_COUNT.getMessage());
        }
    }

    public int size() {
        return players.size();
    }

    public List<String> getPlayerNames() {
        return players.stream()
                .map(player -> player.getName())
                .collect(Collectors.toList());
    }
}
