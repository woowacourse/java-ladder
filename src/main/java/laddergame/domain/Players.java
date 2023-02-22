package laddergame.domain;

import laddergame.constant.ErrorCode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Players {

    private static final int MIN_PLAYER_COUNT = 2;

    private final List<Player> players;

    public Players(List<String> playerNames) {
        List<Player> players = playerNames.stream()
                .map(Player::new)
                .collect(Collectors.toUnmodifiableList());
        validatePlayerNames(players);
        this.players = players;
    }

    private void validatePlayerNames(List<Player> players) {
        Set<Player> playerSet = new HashSet<>(players);
        if (playerSet.size() != players.size()) {
            throw new IllegalArgumentException(ErrorCode.PLAYER_NAME_DUPLICATED.getCode());
        }

        if (players.size() < MIN_PLAYER_COUNT) {
            throw new IllegalArgumentException(ErrorCode.NOT_VALID_PLAYER_COUNT.getCode());
        }
    }

    public int size() {
        return players.size();
    }

    public Position positionOf(String name) {
        Player targetPlayer = new Player(name);
        int index = players.indexOf(targetPlayer);
        validatePositionIndex(index);
        return new Position(index + 1);
    }

    private void validatePositionIndex(int index) {
        if (index == -1) {
            throw new IllegalArgumentException(ErrorCode.PLAYER_NAME_NOT_FOUND.getCode());
        }
    }

    public List<String> getPlayerNames() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }
}
