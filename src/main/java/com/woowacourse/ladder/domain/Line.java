package com.woowacourse.ladder.domain;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Line {
    private final List<Boolean> bridges;
    private final List<Point> points;
    private final List<Direction> directions;

    public Line(List<Boolean> bridges, List<Point> points, List<Direction> directions) {
        this.bridges = bridges;
        this.points = points;
        this.directions = directions;
    }

    public static Point createPoint(int order) {
        return new Point(order, 1000);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(bridges, line.bridges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bridges);
    }

    public Direction creatDirection(boolean left, boolean right) {
        return new Direction(left,right);
    }

    public List<Boolean> getBridges() {
        return bridges;
    }
}
