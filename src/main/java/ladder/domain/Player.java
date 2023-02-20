package ladder.domain;

import java.util.Objects;

public class Player {
    private final PlayerName playerName;

    public Player(String name) {
        this.playerName = new PlayerName(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player other = (Player) o;
        return Objects.equals(playerName, other.playerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName);
    }

    public String getName() {
        return playerName.getName();
    }
}
