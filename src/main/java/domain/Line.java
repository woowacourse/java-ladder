package domain;

import java.util.Collections;
import java.util.List;

public class Line {

    public static final int POINT_MIN_SIZE = 0;
    public static final int POINT_MAX_SIZE = 19;

    private final List<Point> points;

    public Line(final List<Point> points) {
        validate(points.size());
        this.points = points;
    }

    public void validate(final int pointSize) {
        if (pointSize < POINT_MIN_SIZE || pointSize > POINT_MAX_SIZE) {
            throw new IllegalArgumentException("포인트 범위는 0부터 19까지입니다.");
        }
    }

    public Point getPointAt(final int index) {
        return points.get(index);
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

}
