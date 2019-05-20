package ladder.domain.ladder;

/**
 * 플레이어의 위치와 이동을 위한 클래스
 */
public class Position {
    private int position;

    Position(int position) {
        validLowerBound(position);
        this.position = position;
    }

    private void validLowerBound(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("현재 위치는 0 미만 불가능");
        }
    }

    public int getPosition() {
        return position;
    }

    Position move(Point currentPoint) {
        if (currentPoint.canMoveLeft()) {
            return moveLeft();
        }
        if (currentPoint.canMoveRight()) {
            return moveRight();
        }
        return this;
    }


    private Position moveRight() {
        return new Position(this.position + 1);
    }

    private Position moveLeft() {
        return new Position(this.position - 1);
    }
}
