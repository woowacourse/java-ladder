package ladder.domain;

public class Point {

    private int verticalPosition;
    private int horizontalPosition;

    public Point(final int horizontalPosition) {
        this.verticalPosition = 0;
        this.horizontalPosition = horizontalPosition;
    }

    public void moveVertical() {
        verticalPosition++;
    }

    public void moveHorizontal(final Direction direction) {
        if (direction == Direction.LEFT || direction == Direction.RIGHT) {
            final int moveValue = direction.getMove();
            horizontalPosition += moveValue;
        }
    }

    public int getVerticalPosition() {
        return verticalPosition;
    }

    public int getHorizontalPosition() {
        return horizontalPosition;
    }
}
