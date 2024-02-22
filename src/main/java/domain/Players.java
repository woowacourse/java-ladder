package domain;

import java.util.List;

class Players {

    private static final int MIN_PLAYER_SIZE = 2;

    private final List<Player> players;

    public Players(List<String> names) {
        validatePlayerSize(names);
        validateDuplicated(names);
        this.players = mapToPlayer(names);
    }

    private void validatePlayerSize(List<String> names) {
        if (names.size() < MIN_PLAYER_SIZE) {
            throw new IllegalArgumentException("사용자는 최소 2명이여야 한다.");
        }
    }

    private void validateDuplicated(List<String> names) {
        long count = names.stream().distinct().count();
        if (count != names.size()) {
            throw new IllegalArgumentException("사용자는 중복될 수 없다.");
        }
    }

    public List<Player> mapToPlayer(List<String> names) {
        return names.stream()
                .map(name -> new Player(name.trim()))
                .toList();
    }

    public List<Player> getPlayers() {
        return players;
    }
}
