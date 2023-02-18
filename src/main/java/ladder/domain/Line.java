package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private final int width;
    private final List<Point> points = new ArrayList<>();
    private final RandomGenerator<Boolean> pointGenerator;

    public Line(final RandomGenerator<Boolean> pointGenerator, final int width) {
        validateWidth(width);
        this.pointGenerator = pointGenerator;
        this.width = width;
        initialize();
    }

    private void validateWidth(final int width) {
        if (width < 1) {
            throw new IllegalArgumentException("라인의 넓이는 1이상이어야 합니다.\n" + "width : " + width);
        }
    }

    private void initialize() {
        for (int index = 0; index < width; index++) {
            points.add(generatePoint(index));
        }
    }

    private Point generatePoint(final int index) {
        if (isPossible(index)) {
            Boolean generate = pointGenerator.generate();
            return Point.from(generate);
        }
        return Point.DISABLE;
    }

    private Boolean isPossible(final int index) {
        if (points.isEmpty()) {
            return true;
        }

        return !points.get(index - 1).isAvailable();
    }

    public List<Point> toUnmodifiableLine() {
        return Collections.unmodifiableList(points);
    }
}
