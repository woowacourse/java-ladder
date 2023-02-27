package laddergame.domain;

import static laddergame.domain.Point.of;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Point> points = new ArrayList<>();

    public Line(final List<Boolean> points) {
        if (points.isEmpty()) {
            throw new IllegalArgumentException("사다리의 가로는 한 칸 이상이어야합니다.");
        }
        for (final Boolean isFilled : points) {
            this.points.add(of(isFilled));
        }
    }

    public List<Point> getPoints() {
        return points;
    }

    public boolean isPointFilledAt(int index) {
        try {
            return points.get(index).isFilled();
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("인덱스가 라인의 길이를 벗어납니다.");
        }
    }
}
