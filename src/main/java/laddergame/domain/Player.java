package laddergame.domain;

import java.util.Objects;

public class Player {
    private final PlayerName name;

    public Player(final PlayerName name) {
        this.name = name;
    }

    // TODO: 플레이어의 이름을 받아오려고 PlayerGroup.getPlayers > Player.getName() > PlayerName.getName()를 하는 것보다 좋은 방법은 없나?
    public String getName() {
        return name.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    /*@Override
    public String toString() {
        return this.name;
    }*/

    public boolean hasSameName(String name) {
        return this.name.equals(name);
    }
}
