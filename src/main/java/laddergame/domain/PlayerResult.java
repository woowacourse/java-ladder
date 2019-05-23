package laddergame.domain;

import java.util.List;
import java.util.Objects;

public class PlayerResult {
    private final List<Player> players;

    public PlayerResult(final List<Player> players) {
        this.players = players;
    }

    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerResult that = (PlayerResult) o;
        return Objects.equals(players, that.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }
}
