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

    public int count() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<String> getNames() {
        return null;
    }
}
