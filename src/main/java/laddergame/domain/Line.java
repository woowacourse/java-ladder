package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private static final int RIGHT_POINT = 1;
    private static final int LEFT_POINT = -1;

    private List<Point> points;

    public Line(final List<Point> points) {
        this.points = points;
    }

    public Line(final int numberOfPerson) {
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < numberOfPerson; i++) {
            points.add(Point.STRAIGHT);
        }
        this.points = points;
    }

    public boolean canAddScaffold(final int index) {
        return points.get(index).equals(Point.STRAIGHT) &&
                points.get(index + RIGHT_POINT).equals(Point.STRAIGHT);
    }

    public void addScaffold(final int index) {
        if (isLastScaffold(index)) {
            points.set(index, Point.LEFT);
            points.set(index + LEFT_POINT, Point.RIGHT);
            return;
        }
        points.set(index + RIGHT_POINT, Point.LEFT);
        points.set(index, Point.RIGHT);
    }

    private boolean isLastScaffold(final int index) {
        return (index + RIGHT_POINT) == points.size();
    }

    public List<Point> getPoints() {
        return points;
    }

    public int moveNextPoint(int position) {
        if (position < 0 || position + RIGHT_POINT > points.size()) {
            throw new IllegalArgumentException("발판의 범위를 벗어났습니다!");
        }
        return points.get(position).move(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
