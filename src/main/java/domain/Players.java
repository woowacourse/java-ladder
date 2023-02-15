package domain;

import java.util.List;

public class Players {

    public static final int PLAYER_MIN_SIZE = 1;
    public static final int PLAYER_MAX_SIZE = 20;

    public Players(List<Player> players) {
        validate(players);
    }

    private void validate(List<Player> players) {
        if (players.size() < PLAYER_MIN_SIZE || players.size() > PLAYER_MAX_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
