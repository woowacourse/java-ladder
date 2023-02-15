package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {
    private final List<LineStatus> statuses;

    public Line(final List<LineStatus> statuses) {
        this.statuses = statuses;
    }

    public List<LineStatus> getLine() {
        return Collections.unmodifiableList(statuses);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Line line = (Line) o;
        return Objects.equals(statuses, line.statuses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statuses);
    }
}
