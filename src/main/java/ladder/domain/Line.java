package ladder.domain;

import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public int ride(int position) {
        if (position > points.size()) {
            throw new IllegalArgumentException("사다리가 존재하지 않는 위치입니다.");
        }
        if (position < points.size() && Point.ON.equals(points.get(position))) {
            return position + 1;
        }
        if (position > 0 && Point.ON.equals(points.get(position - 1))) {
            return position - 1;
        }
        return position;
    }
}
