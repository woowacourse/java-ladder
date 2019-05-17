package laddergame.domain.player;

import laddergame.domain.Constant;

import java.util.List;
import java.util.Objects;

public class Players {
    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public int getNumberOfPlayers() {
        return players.size();
    }

    public int getIndexOfName(String name) {
        if(!players.contains(new Player(name))){
            throw new IllegalArgumentException("존재하지않는 이름입니다.");
        }
        return (players.indexOf(new Player(name)) + 1);
    }

    public String getNameOfIndex(int index) {
        return players.get(index - 1).getName();
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
            stringBuilder.append(String.format("%-" + Constant.BOUND_OF_NAME_LENGTH + "s", player));
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
