package domain.player;

import domain.ladder.Line;
import java.util.Objects;

public class Position {

    private final int value;

    public Position(int position) {
        this.value = position;
    }

    public Position findNextPosition(Position position, Line line) {
        if (line.canMoveLeft(position)) {
            return Movement.GO_LEFT.move(position);
        }
        if (line.canMoveRight(position)) {
            return Movement.GO_RIGHT.move(position);
        }
        return Movement.STAY.move(position);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position1 = (Position) o;
        return value == position1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
