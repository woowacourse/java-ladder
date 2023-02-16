package domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Players {

    private static final int MIN_PLAYER_SIZE = 2;
    private static final int MAX_PLAYER_SIZE = 50;

    private final List<Player> players;

    public Players(List<Player> players) {
        validateDuplicate(players);
        validateSize(players);
        this.players = players;
    }

    private void validateDuplicate(List<Player> players) {
        Set<Player> uniqueNamePlayers = new HashSet<>(players);

        if (uniqueNamePlayers.size() != players.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateSize(List<Player> players) {
        if (players.size() < MIN_PLAYER_SIZE || players.size() > MAX_PLAYER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
