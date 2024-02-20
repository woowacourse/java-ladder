package domain;

import java.util.Objects;

public class Point {
    private final boolean hasStep;

    public Point(boolean hasStep) {
        this.hasStep = hasStep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return hasStep == point.hasStep;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hasStep);
    }

    public boolean isHasStep() {
        return hasStep;
    }
}
