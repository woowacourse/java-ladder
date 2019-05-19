package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class PlayerManager {
    private List<Player> players;

    public void createPlayers(List<String> names) {
        players = new ArrayList<>();
        for (String name : names) {
            players.add(new Player(name, players.size()));
        }
    }

    public List<Player> getPlayers() {
        return players;
    }
}
