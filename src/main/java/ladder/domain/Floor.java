package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Floor {

    private static final int SECOND_INDEX_OF_FLOOR = 1;
    private final List<Point> points;

    public Floor(List<Boolean> values) {

        List<Point> points = values.stream()
                .map(Point::of)
                .collect(Collectors.toList());

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

    public List<Boolean> getPoints() {
        return points.stream()
                .map(Point::isExist)
                .collect(Collectors.toList());
    }
}
