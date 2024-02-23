package domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {
    private final List<Step> steps;

    public Line(final List<Step> steps) {
        this.steps = steps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(steps, line.steps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(steps);
    }

    public List<Step> getSteps() {
        return Collections.unmodifiableList(steps);
    }
}
