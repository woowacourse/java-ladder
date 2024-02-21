package model;

import java.util.List;

public class Players {

    private final List<Player> players;

    public Players(List<String> players) {
        validate(players);
        this.players = players.stream()
                .map(Player::new)
                .toList();
    }

    private void validate(List<String> players) {
        if (players.size() < 2) {
            throw new IllegalArgumentException();
        }
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
