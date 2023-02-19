package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Floor {

    private static final int SECOND_INDEX_OF_FLOOR = 1;
    private final List<Point> points;

    public Floor(List<Point> values) {

        List<Point> points = new ArrayList<>(values);

        removeContinuousLine(points);

        this.points = points;
    }

    private void removeContinuousLine(List<Point> pointCandidate) {
        for (int i = SECOND_INDEX_OF_FLOOR; i < pointCandidate.size(); i++) {
            if (pointCandidate.get(i - 1).equals(Point.FILLED)) {
                pointCandidate.set(i, Point.EMPTY);
            }
        }
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
