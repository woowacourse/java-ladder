package ladder.domain;

import java.util.List;

public class Row {
    private final List<Boolean> points;

    private Row(List<Boolean> points) {
        validateContinuity(points);
        this.points = points;
    }

    public static Row of(List<Boolean> points, int expectedSize) {
        validateSize(points, expectedSize);
        return new Row(points);
    }

    private static void validateSize(List<Boolean> points, int expectedSize) {
        if (points.size() != expectedSize) {
            throw new IllegalArgumentException();
        }
    }

    private void validateContinuity(List<Boolean> points) {
        for (int position = 0; position < points.size() - 1; position++) {
            if (isConsecutiveStep(points, position)) {
                throw new IllegalArgumentException("");
            }
        }
    }

    private boolean isConsecutiveStep(List<Boolean> points, int position) {
        return points.get(position) == true && points.get(position + 1) == true;
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
