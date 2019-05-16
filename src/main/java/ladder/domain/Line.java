package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Line {
    static final int LEFT = -1;
    static final int STRAIGHT = 0;
    static final int RIGHT = 1;

    private final List<Boolean> points;

    public Line(final List<Boolean> points) {
        if (isConsecutive(points)) {
            throw new IllegalArgumentException();
        }

        this.points = points;
    }

    private boolean isConsecutive(List<Boolean> points) {
        return Collections.indexOfSubList(points, Arrays.asList(true, true)) != -1;
    }

    int getDirection(int position) {
        if (position != 0 && points.get(position - 1)) {
            return LEFT;
        }
        if (position != points.size() && points.get(position)) {
            return RIGHT;
        }
        return STRAIGHT;
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
