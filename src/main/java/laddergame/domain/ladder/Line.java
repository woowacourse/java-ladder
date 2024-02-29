package laddergame.domain.ladder;

import laddergame.domain.result.Trace;
import laddergame.domain.point.Point;
import laddergame.domain.point.PointGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Point> points;

    public Line(final List<Point> points) {
        this.points = points;
    }

    public static Line create(final LineSize lineSize, final PointGenerator pointGenerator) {
        List<Point> points = new ArrayList<>();

        while (lineSize.isBiggerThan(points.size())) {
            points.add(generatePoint(points, pointGenerator));
        }

        return new Line(points);
    }

    private static Point generatePoint(final List<Point> points, final PointGenerator pointGenerator) {
        if (points.isEmpty()) {
            return pointGenerator.generate();
        }

        Point lastPoint = points.get(points.size() - 1);
        if (lastPoint.isExist()) {
            return Point.EMPTY;
        }

        return pointGenerator.generate();
    }

    public Trace move(final Trace trace) {
        if (canMoveLeft(trace)) {
            return trace.moveLeft();
        }

        if (canMoveRight(trace)) {
            return trace.moveRight();
        }

        return trace;
    }

    private boolean canMoveLeft(final Trace trace) {
        if (trace.getPosition() == 0) {
            return false;
        }
        return hasPoint(trace.getPosition() - 1);
    }

    private boolean canMoveRight(final Trace trace) {
        if (trace.getPosition() == this.points.size()) {
            return false;
        }
        return hasPoint(trace.getPosition());
    }

    private boolean hasPoint(int position) {
        return points.get(position).isExist();
    }

    public List<Boolean> getPointsState() {
        return points.stream()
                .map(Point::isExist)
                .toList();
    }
}
