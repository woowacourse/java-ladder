package ladder.domain;

import java.util.List;
import java.util.Objects;

public class Line {
    private static final String LADDER_TRUE = "-----|";
    private static final String LADDER_FALSE = "     |";

    private final List<Boolean> points;

    Line(final List<Boolean> points) {
        this.points = points;
    }

    String makeLine() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < points.size() - 1; i++) {
            sb.append(makeRow(i));
        }
        return sb.toString() + "\n";
    }

    private String makeRow(int index) {
        if (points.get(index)) {
            return LADDER_TRUE;
        }
        return LADDER_FALSE;
    }

    int move(int index) {
        if (points.get(index)) {
            return ++index;
        }
        if (points.get(index - 1)) {
            return --index;
        }
        return index;
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


