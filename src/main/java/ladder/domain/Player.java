package ladder.domain;

import java.util.Objects;

public class Player {
    private final PlayerName name;
    private PlayerPosition position;

    public Player(String name) {
        this.name = new PlayerName(name);
    }

    public Player(PlayerName name, PlayerPosition position) {
        this.name = name;
        this.position = position;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player p = (Player) o;
        return Objects.equals(name, p.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name.getName();
    }

    public PlayerPosition getPosition() {
        return position;
    }
}
