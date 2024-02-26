package domain;

public class Position {
    private int position;

    public Position(int position) {
        validatePosition(position);
        this.position = position;
    }

    private void validatePosition(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("위치는 0이상이어야 합니다.");
        }
    }

    public void move(Direction direction) {
        if (direction == Direction.LEFT) {
            position--;
        }
        if (direction == Direction.RIGHT) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
