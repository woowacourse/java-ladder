package ladder.domain;

import java.util.function.UnaryOperator;

/**
 * 사다리의 가로 세로의 교차점을 나타내는 클래스
 * <p>
 * 왼쪽으로 이동가능, 오른쪽으로 이동가능, 이동하지 않음 상태를 표현하고 있음
 */
public enum Point {
    LEFT(Position::moveLeft),
    RIGHT(Position::moveRight),
    NONE(UnaryOperator.identity());

    private final UnaryOperator<Position> move;

    Point(UnaryOperator<Position> move) {
        this.move = move;
    }

    public Position move(Position position) {
        return move.apply(position);
    }

    public Point next(ConnectionJudgement connectionJudgement) {
        if (this == RIGHT) {
            return LEFT;
        }
        boolean connected = connectionJudgement.judge();
        if (connected) {
            return RIGHT;
        }
        return NONE;
    }

    public boolean isRightConnected() {
        return this == RIGHT;
    }
}
