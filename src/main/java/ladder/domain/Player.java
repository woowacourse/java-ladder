package ladder.domain;

import java.util.Objects;

public class Player {
    private final String name;
    private final Position position;

    public Player(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Player move(Direction direction) {
        Position newPosition = new Position(position.getValue() + direction.move());
        return new Player(name, newPosition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name) &&
                Objects.equals(position, player.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
