package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Boolean> points;

    public Line(int personCount) {
        this.points = new ArrayList<>();
        for (int i = 0; i < personCount - 1; i++) {
            points.add(false);
        }
    }

    public Line(List<Boolean> points) {
        validate(points);
        this.points = points;
    }

    private void validate(List<Boolean> points) {
        Boolean flag = points.get(0);

        for (int i = 1; i < points.size(); i++) {
            validateSequential(points, flag, i);
            flag = points.get(i);
        }
    }

    private void validateSequential(List<Boolean> points, Boolean flag, int index) {
        if (points.get(index) & flag) {
            throw new IllegalArgumentException("연속된 true가 나올 수 없습니다.");
        }
    }

    public int size() {
        return points.size();
    }
}
