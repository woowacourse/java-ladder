package laddergame.domain;

import laddergame.domain.rule.Rule;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public Line(int numberOfPoints, Rule rule) {
        if (numberOfPoints < 2) {
            throw new IllegalArgumentException("2개 이상의 포인트가 필요합니다.");
        }

        points = new ArrayList<>();
        while (points.size() != numberOfPoints) {
            makePoint(numberOfPoints, rule);
        }
    }

    private void makePoint(int numberOfPoints, Rule rule) {
        if (points.size() == 0) {
            points.add(Point.first(rule));
            return;
        }

        Point prevPoint = points.get(points.size() - 1);
        if (points.size() == numberOfPoints - 1) {
            points.add(prevPoint.last());
            return;
        }
        points.add(prevPoint.next(rule));
    }

    public int moveNextPoint(int position) {
        if (outOfPointRange(position)) {
            throw new IllegalArgumentException("이동 범위를 벗어났습니다.");
        }
        return points.get(position).move(position);
    }

    private boolean outOfPointRange(int position) {
        return (position < 0) || (position >= points.size());
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

    @Override
    public String toString() {
        StringBuilder lineView = new StringBuilder();
        for (Point point : points) {
            lineView.append(point);
        }
        return lineView.toString();
    }
}
