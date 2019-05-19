package ladder.domain;

import java.util.List;
import java.util.Objects;

public final class Line {
    private static final int MIN_PLAYER = 2;

    private final List<Direction> directions;

    public Line(final List<Direction> directions) {
        validateSize(directions.size());
        this.directions = directions;
    }

    private void validateSize(int countOfPerson) {
        if (countOfPerson < MIN_PLAYER) {
            throw new IllegalArgumentException("사람수는 2명 이상 이어야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(directions, line.directions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(directions);
    }
}