package domain.player;

import java.util.Objects;

public class Player {

    private final Name name;
    private Position position;

    public Player(final Name name) {
        this(name, new Position(0));
    }

    public Player(final Name name, final Position position) {
        this.name = name;
        this.position = position;
    }

    public void move(final Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return this.name.toString();
    }
}
