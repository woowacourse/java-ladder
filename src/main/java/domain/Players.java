package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private final List<Player> players;

    public Players(List<String> names) {
        players = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            players.add(new Player(names.get(i), i));
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getPlayerSize() {
        return players.size();
    }
}
