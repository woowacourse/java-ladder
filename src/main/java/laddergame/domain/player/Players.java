package laddergame.domain.player;

import java.util.List;
import java.util.Objects;

public class Players {
    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public int getPlayersSize() {
        return players.size();
    }

    public boolean contains(String name) {
        return players.contains(new Player(name));
    }

    public String getNameOfIndex(int index) {
        return players.get(index).getName();
    }

    public boolean isSameSize(int size) {
        return players.size() == size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Players)) return false;
        Players that = (Players) o;
        return Objects.equals(players, that.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Player player : players) {
            stringBuilder.append(String.format("%6s", player.getName()));
        }
        return stringBuilder.toString();
    }
}
