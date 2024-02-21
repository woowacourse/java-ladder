package model;

import java.util.List;
import java.util.Set;

public class Players {

    private final List<Player> players;

    public Players(List<String> players) {
        validate(players);
        this.players = players.stream()
                .map(Player::new)
                .toList();
    }

    private void validate(List<String> players) {
        validateSize(players);
        validateDuplicates(players);
    }

    private void validateSize(List<String> players) {
        if (players.size() < 2) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicates(List<String> players) {
        if(isDuplicated(players)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDuplicated(List<String> players) {
        return Set.copyOf(players).size() != players.size();
    }

    public List<String> getNames() {
        return players.stream()
                .map(Player::getName)
                .toList();
    }

    public int size() {
        return players.size();
    }
}
