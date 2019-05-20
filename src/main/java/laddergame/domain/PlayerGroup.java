package laddergame.domain;

import java.util.List;
import java.util.Objects;

public class PlayerGroup {
    private final List<Player> players;

    public PlayerGroup(final List<Player> names) {
        this.players = names;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getCountOfPlayers() {
        return players.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerGroup that = (PlayerGroup) o;
        return Objects.equals(players, that.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }
}
