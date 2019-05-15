package ladder.domain;

import java.util.List;
import java.util.Objects;

class Line {
    private final List<Boolean> points;

    Line(final List<Boolean> points) {
        this.points = points;
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


