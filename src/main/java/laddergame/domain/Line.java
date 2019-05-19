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

        Point point =  Point.first(rule);
        points.add(point);
        for (int i = 1; i < numberOfPoints - 1; i++) {
            point = point.next(rule);
            points.add(point);
        }
        points.add(point.last());
    }

    public int moveNextPoint(int position) {
        if (outOfPointRange(position)) {
            throw new IllegalArgumentException("이동 범위를 벗어났습니다.");
        }
        return points.get(position).move(position);
    }

    private boolean outOfPointRange(int position) {
        return (position < 0) || (position > points.size() - 1);
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
