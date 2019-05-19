package laddergame.domain;

import java.util.Objects;

public class Direction {
    private boolean canMove;

    public Direction(boolean canMove) {
        this.canMove = canMove;
    }

    public boolean canMove() {
        return canMove;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction = (Direction) o;
        return canMove == direction.canMove;
    }

    @Override
    public int hashCode() {
        return Objects.hash(canMove);
    }

    @Override
    public String toString() {
        return canMove ? "---" : "   ";
    }
}
