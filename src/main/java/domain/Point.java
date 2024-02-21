package domain;

import java.util.Objects;

public class Point {
    private final Step step;

    public Point(Step step) {
        this.step = step;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return step == point.step;
    }

    @Override
    public int hashCode() {
        return Objects.hash(step);
    }

    public Step getStep() {
        return step;
    }
}
