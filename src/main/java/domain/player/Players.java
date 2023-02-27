package domain.player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Players {

    private final List<Player> players;

    public Players(final Names names) {
        this.players = createPlayers(names);
    }

    private List<Player> createPlayers(final Names names) {
        List<Player> players = new ArrayList<>();
        List<Name> onlyNames = names.getNames();

        for (int playerCount = 0; playerCount < onlyNames.size(); playerCount++) {
            players.add(new Player(onlyNames.get(playerCount), new Position(playerCount)));
        }

        return players;
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
