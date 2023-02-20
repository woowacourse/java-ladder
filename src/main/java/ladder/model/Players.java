package ladder.model;

import ladder.exceptionMessage.ExceptionMessage;

import java.util.Collections;
import java.util.List;

public class Players {

    private static final int MIN_PLAYER_COUNT = 2;

    private final List<Player> players;

    public Players(List<Player> players) {
        validatePlayerCount(players);
        this.players = players;
    }

    private void validatePlayerCount(List<Player> players) {
        if (players.size() < MIN_PLAYER_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.EXCEPTION_INVALID_PLAYER_COUNT.getMessage());
        }
    }

    public int size() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

}
