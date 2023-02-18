package laddergame.domain;

import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private final List<Boolean> points;

    public Line(final List<Boolean> points) {
        validateNotEmpty(points);
        validateNotBothTrue(points);
        this.points = points;
    }

    private void validateNotBothTrue(final List<Boolean> points) {
        boolean isBothTrue = IntStream.range(0, points.size() - 1)
                .anyMatch(pointIndex -> points.get(pointIndex) && points.get(pointIndex + 1));
        if (isBothTrue) {
            throw new IllegalArgumentException("boolean 리스트는 비어있을 수 없습니다.");
        }
    }

    private void validateNotEmpty(final List<Boolean> points) {
        if (points.isEmpty()) {
            throw new IllegalArgumentException("사다리의 가로 라인은 겹칠 수 없습니다.");
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
