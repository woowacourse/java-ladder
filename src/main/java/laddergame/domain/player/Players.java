package laddergame.domain.player;

import laddergame.BuilderObject;
import laddergame.domain.Constant;

import java.util.List;
import java.util.Objects;

public class Players implements BuilderObject {
    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    @Override
    public String getNameOfIndex(int index) {
        return players.get(index - 1).getName();
    }

    @Override
    public boolean isSizeEqual(BuilderObject other) {
        return (this.players.size() == other.getSize());
    }

    @Override
    public int getSize() {
        return players.size();
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
            stringBuilder.append(String.format("%-" + player.BOUND_OF_NAME_LENGTH + "s", player));
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
