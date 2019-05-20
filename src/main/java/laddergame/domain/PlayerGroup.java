package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PlayerGroup {
    private List<Player> players = new ArrayList<>();

    public PlayerGroup(List<Player> names) {
        this.players = players;
    }

    public List<Player> getPlayers() {
        return players;
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
