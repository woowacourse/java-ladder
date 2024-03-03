package domain.player;

import java.util.List;

public class Players {

    protected static final int MIN_PLAYER_SIZE = 2;
    protected static final String PLAYER_DUPLICATED_MESSAGE = "사용자는 중복될 수 없습니다.";
    protected static final String MIN_PLAYER_SIZE_MESSAGE = String.format("사용자는 최소 %d명이어야 합니다.", MIN_PLAYER_SIZE);

    private final List<Player> players;

    public Players(List<String> playerNames) {
        validateDuplicated(playerNames);
        validatePlayerSize(playerNames);

        this.players = convertToPlayer(playerNames);
    }

    private void validateDuplicated(List<String> names) {
        if (getUniqueSize(names) != names.size()) {
            throw new IllegalArgumentException(PLAYER_DUPLICATED_MESSAGE);
        }
    }

    private void validatePlayerSize(List<String> names) {
        if (names.size() < MIN_PLAYER_SIZE) {
            throw new IllegalArgumentException(MIN_PLAYER_SIZE_MESSAGE);
        }
    }

    private long getUniqueSize(List<String> names) {
        return names.stream().distinct().count();
    }

    private List<Player> convertToPlayer(List<String> names) {
        return names.stream()
                .map(name -> new Player(name.trim()))
                .toList();
    }

    public List<String> getPlayerNames() {
        return this.players.stream()
                .map(Player::getName)
                .toList();
    }

    public int getPlayerSize() {
        return this.players.size();
    }

    public int getStartPositionOf(String playerName) {
        return getPlayerNames().indexOf(playerName);
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public boolean isPlayerExistByName(String name) {
        return getPlayerNames().contains(name);
    }
}
