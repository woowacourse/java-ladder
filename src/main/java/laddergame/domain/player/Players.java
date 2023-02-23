package laddergame.domain.player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Players {

    private final List<Player> players;

    public Players(final Names names) {
        this.players = createPlayers(names);
    }

    private static List<Player> createPlayers(final Names names) {
        List<Player> players = new ArrayList<>();

        final List<String> playerNames = names.getNames();
        for (int position = 0; position < playerNames.size(); position++) {
            final Player player = Player.of(playerNames.get(position), position);
            players.add(player);
        }

        return players;
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public int getPlayerSize() {
        return players.size();
    }
}
