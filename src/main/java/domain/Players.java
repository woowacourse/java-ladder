package domain;

import java.util.List;

class Players {

    private final List<Player> players;

    public Players(List<String> names) {
        validatePlayerSize(names);
        this.players = mapToPlayer(names);
    }

    public List<Player> mapToPlayer(List<String> names) {
        return names.stream()
                .map(name -> new Player(name.trim()))
                .toList();
    }

    private void validatePlayerSize(List<String> names) {
        if (names.size() < 2) {
            throw new IllegalArgumentException("사용자는 최소 2명이여야 한다.");
        }
    }

    public List<Player> getPlayers() {
        return players;
    }
}
