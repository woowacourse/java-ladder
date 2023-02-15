package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Players {

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
        if (players.size() < 2 || players.size() > 50) {
            throw new IllegalArgumentException();
        }
    }
}
