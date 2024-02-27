package domain;

import static message.ErrorMessage.INVALID_PLAYER_COUNT_EXCEPTION;

import java.util.List;

public class Players {

    private static final int MINIMUM_PLAYER_COUNT = 2;

    private final List<Player> players;

    public Players(List<Player> players) {
        validatePlayerSize(players);
        this.players = players;
    }

    private static void validatePlayerSize(List<Player> players) {
        if (players.size() < MINIMUM_PLAYER_COUNT) {
            throw new IllegalArgumentException(INVALID_PLAYER_COUNT_EXCEPTION.getMessage());
        }
    }

    public int getPlayerOrderNumber(String name) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
