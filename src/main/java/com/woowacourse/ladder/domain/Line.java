package com.woowacourse.ladder.domain;

import java.util.List;
import java.util.Objects;

public class Line {
    private final List<Boolean> bridges;
    private final List<Direction> directions;

    public Line(List<Boolean> bridges, List<Direction> directions) {
        this.bridges = bridges;
        this.directions = directions;
    }

    public int requestNextDestination(int index) {
        index += this.directions.get(index).move();
        return index;
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

    public List<Boolean> getBridges() {
        return bridges;
    }
}
