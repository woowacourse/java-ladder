package ladderGame.model;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private final List<Player> players;

    public Players(List<String> names) {
        players = new ArrayList<>();
        for(String name : names) {
            players.add(new Player(name));
        }
    }
}
