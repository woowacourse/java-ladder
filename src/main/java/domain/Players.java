package domain;

import java.util.List;
import java.util.NoSuchElementException;

public class Players {

    private static final int MIN_PLAYER_SIZE = 2;

    private final List<Player> players;

    public Players(List<String> playerNames) {
        validatePlayerSize(playerNames);
        validateDuplicated(playerNames);

        this.players = mapToPlayer(playerNames);
    }

    private void validatePlayerSize(List<String> names) {
        if (names.size() < MIN_PLAYER_SIZE) {
            throw new IllegalArgumentException(String.format("사용자는 최소 %d명이어야 합니다.", MIN_PLAYER_SIZE));
        }
    }

    private void validateDuplicated(List<String> names) {
        if (getUniqueSize(names) != names.size()) {
            throw new IllegalArgumentException("사용자는 중복될 수 없습니다.");
        }
    }

    private long getUniqueSize(List<String> names) {
        return names.stream().distinct().count();
    }

    private List<Player> mapToPlayer(List<String> names) {
        return names.stream()
                .map(name -> new Player(name.trim()))
                .toList();
    }

    public int findPlayerColumn(String name) {
        Player foundPlayer = players.stream()
                .filter(player -> player.isSameName(name))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("존재하지 않는 사용자입니다."));

        return players.indexOf(foundPlayer);
    }

    public List<Player> getPlayers() {
        return players;
    }
}
