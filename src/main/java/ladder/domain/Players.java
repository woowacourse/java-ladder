package ladder.domain;

import java.util.Collections;
import java.util.List;

public class Players {
    private final List<PlayerName> players;

    public Players(List<PlayerName> playerNames) {
        this.players = playerNames;
    }

    public void changePosition(int present, int after) {
        Collections.swap(players, present, after);
    }

    public List<PlayerName> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
