package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PlayerGroup implements Cloneable {
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

    public PlayerGroup clone() {
        List<Player> players = new ArrayList<>();

        for (Player player : this.players) {
            players.add(player);
        }

        return new PlayerGroup(players);
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
