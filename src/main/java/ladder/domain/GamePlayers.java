package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public final class GamePlayers {
    private final List<Player> players;

    public GamePlayers(final List<Player> players) {
        validateSize(players);
        this.players = new ArrayList<>(players);
    }

    private void validateSize(List<Player> players) {
        if (players.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
