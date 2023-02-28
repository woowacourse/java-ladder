package domain.ladder;

public class Position {

    private final int value;

    public Position(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("위치 값은 0보다 작을 수 없습니다.");
        }
        this.value = value;
    }

    public Position moveTo(Direction direction) {
        if (direction.equals(Direction.LEFT)) {
            return left();
        }
        if (direction.equals(Direction.RIGHT)) {
            return right();
        }
        return straight();
    }

    private Position left() {
        return new Position(value - 1);
    }

    private Position right() {
        return new Position(value + 1);
    }

    private Position straight() {
        return new Position(value);
    }

    public int getValue() {
        return value;
    }
}
