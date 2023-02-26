package domain.ladder;

import java.util.List;

public class Position {

    private final int value;

    public Position(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("위치 값은 0보다 작을 수 없습니다.");
        }
        this.value = value;
    }

    public Position moveDirection(Direction direction) {
        return new Position(value + direction.getMovement());
    }

    public boolean canMoveLeft(List<Boolean> points, Position position) {
        return position.value > 0 && points.get(position.value - 1);
    }

    public boolean canMoveRight(List<Boolean> points, Position position) {
        return position.value < points.size() && points.get(position.value);
    }

    public int getValue() {
        return value;
    }
}
