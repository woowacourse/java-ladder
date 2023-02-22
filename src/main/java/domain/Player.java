package domain;

import java.util.Objects;

public class Player {

    private final Name name;
    private Position position;

    public Player(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public void move(Lines lines) {
        this.position = new Position(lines.getExitIndex(this.position.getPosition()));
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name=" + name +
                ", position=" + position +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player = (Player) o;
        return Objects.equals(name, player.name) && Objects.equals(position, player.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }


}
