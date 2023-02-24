package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private static final int MAX_WIDTH = 1;

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
        if (width < MAX_WIDTH) {
            throw new IllegalArgumentException("라인의 넓이는 1이상이어야 합니다.\n" + "width : " + width);
        }
    }

    private void initialize() {
        for (int index = 0; index < width; index++) {
            points.add(generatePoint(index));
        }
    }

    private Point generatePoint(final int index) {
        Boolean generate = pointGenerator.generate();
        if (isPossible(index)) {
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

    public Direction decideDirection(final int position) {
        Point right = decidePoint(position);
        if (right.isAvailable()) {
            return Direction.RIGHT;
        }

        Point left = decidePoint(position - 1);
        if (left.isAvailable()) {
            return Direction.LEFT;
        }

        return Direction.STRAIGHT;
    }

    private Point decidePoint(final int position) {
        if (isOutOfBound(position)) {
            return Point.DISABLE;
        }
        return points.get(position);
    }

    private boolean isOutOfBound(final int position) {
        return position < 0 || points.size() <= position;
    }
    
    public List<Point> toUnmodifiableLine() {
        return Collections.unmodifiableList(points);
    }
}
