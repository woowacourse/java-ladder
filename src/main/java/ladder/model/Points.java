package ladder.model;

import java.util.List;

public class Points {
    List<Boolean> points;

    public Points(List<Boolean> points) {
        this.points = points;
    }

    public boolean isTrue(int index) {
        return points.get(index);
    }

    public boolean isUnderLast(int index) {
        return index < points.size();
    }

    public int size() {
        return points.size();
    }
}
