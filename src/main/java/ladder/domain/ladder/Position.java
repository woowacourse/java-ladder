package ladder.domain.ladder;

/**
 * 현재 위치
 */
public class Position {
    private int position;
    private int max;

    public Position(int position, int max) {
        validLowerBound(position);
        validUpperBound(position, max);
        this.position = position;
        this.max = max;
    }

    private void validLowerBound(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("현재 위치는 0 미만 불가능");
        }
    }

    private void validUpperBound(int position, int max) {
        if (position > max) {
            throw new IllegalArgumentException("사다리 폭을 벗어날 수 없음");
        }
    }

    public int getPosition() {
        return position;
    }

    public Position move(Point currentPoint) {
        if (currentPoint.canMoveLeft()) {
            return moveLeft();
        }
        if (currentPoint.canMoveRight()) {
            return moveRight();
        }
        return this;
    }

    public Boolean isFirst() {
        return position == 0;
    }

    public Boolean isLast() {
        return position == max - 1;
    }

    private Position moveRight() {
        return new Position(this.position + 1, this.max);
    }

    private Position moveLeft() {
        return new Position(this.position - 1, this.max);
    }
}
