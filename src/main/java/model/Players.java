package model;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.List;

public class Players {
    private static final int MIN_SIZE_OF_PLAYERS = 2;
    private static final String INVALID_SIZE_OF_PLAYERS = "참여자 수는 최소 2명입니다.";

    private final List<Player> players;

    private Players(List<Player> players) {
        validateSizeOfPlayers(players);
        this.players = players;
    }

    private void validateSizeOfPlayers(List<Player> players) {
        if (players.size() < MIN_SIZE_OF_PLAYERS) {
            throw new IllegalArgumentException(INVALID_SIZE_OF_PLAYERS);
        }
    }

    public static Players create(List<String> names) {
        return names.stream()
                .map(Player::new)
                .collect(collectingAndThen(toList(), Players::new));
    }
}
