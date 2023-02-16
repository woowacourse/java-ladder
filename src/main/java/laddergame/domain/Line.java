package laddergame.domain;

import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private final List<Boolean> points;

    public Line(final List<Boolean> points) {
        if (points.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (points.stream().allMatch(point -> point == false)) {
            throw new IllegalArgumentException();
        }
        boolean isBothTrue = IntStream.range(0, points.size() - 1)
                .anyMatch(pointIndex -> points.get(pointIndex) && points.get(pointIndex + 1));
        if (isBothTrue) {
            throw new IllegalArgumentException();
        }
        this.points = points;
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
