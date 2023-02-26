package domain.ladder;

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

    public int getValue() {
        return value;
    }
}
