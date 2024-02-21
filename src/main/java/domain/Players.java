package domain;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private final List<Player> players = new ArrayList<>();

    public Players(final List<String> names) {
        for (final String name : names) {
            players.add(new Player(name));
        }
    }

    public List<Player> getPlayers() {
        return players;
    }
}
