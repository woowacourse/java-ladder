package ladder.domain;

import java.util.List;
import java.util.Objects;

public class Line {
    private List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public int getMovedIndex(int index) {
        if (index == 0) {
            return (isConnected(index)) ? index + 1 : index;
        }
        if (isConnected(index - 1)) return index - 1;
        if (isConnected(index)) return index + 1;

        return index;
    }

    public boolean isConnected(int point) {
        return points.get(point);
    }

    public int getNumberOfPeople() {
        return points.size();
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
