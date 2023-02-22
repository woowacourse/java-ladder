package domain.player;

import domain.ladder.Line;
import domain.ladder.LinePoint;
import java.util.List;
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
        List<LinePoint> points = line.getPoints();

        if (!position.isLeftEnd() && points.get(position.getPosition() - 2).isPassable()) {
            position.moveLeft();
            return;
        }

        if (!position.isRightEnd(points.size() + 1) && points.get(position.getPosition() - 1).isPassable()) {
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
