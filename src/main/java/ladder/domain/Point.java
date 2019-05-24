package ladder.domain;

import java.util.Objects;
import java.util.Random;

public class Point {
    private static final String LINE_STATE_FALSE = "     |";
    private static final String LINE_STATE_TRUE = "-----|";
    private static final Random RANDOM = new Random();

    private final boolean nowPoint;

    public Point() {
        this(true);
    }

    public Point(boolean beforePoint) {
        this.nowPoint = setNextState(beforePoint);
    }

    public static boolean setNextState(boolean beforePoint) {
        if (beforePoint) {
            return false;
        }
        return RANDOM.nextBoolean();
    }

    private static String createLadderState(boolean lineState) {
        if (lineState) {
            return LINE_STATE_TRUE;
        }
        return LINE_STATE_FALSE;
    }

    public boolean isNowPoint() {
        return nowPoint;
    }

    @Override
    public String toString() {
        return createLadderState(nowPoint);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(nowPoint, point.nowPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nowPoint);
    }
}
