package ladder.domain;

import java.util.List;
import java.util.Objects;

public class Line {
    private final List<Boolean> points;

    Line(List<Boolean> points) {
        this.points = points;
    }

    public String makeLine() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < points.size() - 1; i++) {
            sb.append(makeRow(i));
        }
        return sb.toString();
    }

    private String makeRow(int index) {
        if (points.get(index)) {
            return "-----|";
        }
        return "     |";
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


