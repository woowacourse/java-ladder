package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Players {
    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public Players goDown(Line line) {
        List<Player> movedPlayers = new ArrayList<>();

        for (Player player : players) {
            movedPlayers.add(player.moveOn(line));
        }
        return new Players(movedPlayers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Players players1 = (Players) o;
        return Objects.equals(players, players1.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }
}
