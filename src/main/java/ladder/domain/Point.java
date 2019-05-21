package ladder.domain;

import java.util.Objects;
import java.util.Random;

public class Point {
    public static final String LINE_STATE_FALSE = "     |";
    public static final String LINE_STATE_TRUE = "-----|";

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
        return new Random().nextBoolean();
    }

    private static String getStateShape(boolean lineState) {
        if (lineState) {
            return LINE_STATE_TRUE;
        }
        return LINE_STATE_FALSE;
    }

    public boolean getNowPoint() {
        return nowPoint;
    }

    @Override
    public String toString() {
        return getStateShape(nowPoint);
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
