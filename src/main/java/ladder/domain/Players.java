package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private static final List<Player> players = new ArrayList<>();

    public Players(List<PlayerName> names) {
        for (int position = 0; position < names.size(); position++) {
            players.add(new Player(names.get(position), position));
        }
    }

    public int getPlayerNum() {
        return players.size();
    }

    public static List<Player> getPlayers() {
        return players;
    }
}
