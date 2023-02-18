package laddergame.domain;

import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private final List<Boolean> points;

    public Line(final List<Boolean> points) {
        validate(points);
        this.points = points;
    }

    private void validate(final List<Boolean> points) {
        if (points.isEmpty()) {
            throw new IllegalArgumentException("boolean 리스트는 비어있을 수 없습니다.");
        }
        if (hasAdjacentTrue(points)) {
            throw new IllegalArgumentException("사다리의 가로 라인은 겹칠 수 없습니다.");
        }
    }

    private static boolean hasAdjacentTrue(List<Boolean> points) {
        return IntStream.range(0, points.size() - 1)
                .anyMatch(pointIndex -> points.get(pointIndex) && points.get(pointIndex + 1));
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
