package laddergame.domain;

import laddergame.constant.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Players {

    private final List<Player> players;

    public Players(List<String> playerNames) {
        List<Player> tempPlayers = playerNames.stream()
                .map(name -> new Player(name))
                .collect(Collectors.toUnmodifiableList());
        validatePlayerNames(tempPlayers);
        this.players = List.copyOf(tempPlayers);
    }

    private void validatePlayerNames(List<Player> tempPlayers) {
        Set<Player> nameSet = new HashSet<>(tempPlayers);
        if (nameSet.size() != tempPlayers.size()) {
            throw new IllegalArgumentException(ErrorMessage.PLAYER_NAME_DUPLICATED.getMessage());
        }

        if (tempPlayers.size() < 2) {
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
