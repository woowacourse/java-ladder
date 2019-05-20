package com.woowacourse.ladder.domain;

import java.util.List;
import java.util.Objects;

public class Position {

    private final int current;
    private final int max;

    public Position(int current, int max) {
        if (current >= max) {
            throw new IllegalArgumentException("Arguments must 'current' < 'max'");
        }
        this.current = current;
        this.max = max;
    }

    public Position move(Direction direction) {
        int movedPosition = current + direction.getPositionToMove();
        if (movedPosition < 0) {
            throw new IllegalArgumentException();
        }

        return new Position(movedPosition, max);
    }

    public Position moveMatch(List<Direction> directions) {
        return move(directions.get(current));
    }

    public Destination getMatchDestination(DestinationGroup destinations) {
        return destinations.get(current);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return current == position.current &&
            max == position.max;
    }

    @Override
    public int hashCode() {
        return Objects.hash(current, max);
    }

    @Override
    public String toString() {
        return String.format("Position { current: %d }", current);
    }
}
