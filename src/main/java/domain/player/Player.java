package domain.player;

import domain.ladder.Line;
import java.util.Objects;

public class Player {

    private final Name name;
    private Position position;

    public Player(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public boolean isSameName(String otherName) {
        return name.same(otherName);
    }

    public void move(Line line) {
        if (position.isLeftSidePassable(line)) {
            position.moveLeft();
            return;
        }

        if (position.isRightSidePassable(line)) {
            position.moveRight();
        }
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Player otherPlayer = (Player) other;
        return Objects.equals(this.name, otherPlayer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
