package domain;

import java.util.Collections;
import java.util.List;

class Players {
    private final List<Player> players;

    Players(List<Player> players) {
        this.players = Collections.unmodifiableList(players);
    }

    static Players of(String... playerNames) {
        return new Players(null);
    }
}
