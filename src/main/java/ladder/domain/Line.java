package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Line {
    private List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;

        if (isConsecutive()) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isConsecutive() {
        return Collections.indexOfSubList(points, Arrays.asList(true, true)) != -1;
    }

    Direction getDirection(int position) {
        if (position != 0 && points.get(position - 1)) {
            return Direction.LEFT;
        }
        if (position != points.size() && points.get(position)) {
            return Direction.RIGHT;
        }
        return Direction.STRAIGHT;
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
