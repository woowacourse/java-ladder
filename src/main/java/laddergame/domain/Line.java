package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private static final String LINE_POINTS_BOTH_TRUE_EXCEPTION = "사다리의 가로 라인은 겹칠 수 없습니다.";
    private static final String LINE_POINTS_EMPTY_EXCEPTION = "boolean 리스트는 비어있을 수 없습니다.";

    private final List<Boolean> points;

    public Line(final List<Boolean> points) {
        validatePoints(points);
        this.points = points;
    }

    private void validatePoints(final List<Boolean> points) {
        if (points.isEmpty()) {
            throw new IllegalArgumentException(LINE_POINTS_EMPTY_EXCEPTION);
        }
        boolean isBothTrue = IntStream.range(0, points.size() - 1)
                .anyMatch(pointIndex -> points.get(pointIndex) && points.get(pointIndex + 1));
        if (isBothTrue) {
            throw new IllegalArgumentException(LINE_POINTS_BOTH_TRUE_EXCEPTION);
        }
    }

    public List<Boolean> getPoints() {
        return new ArrayList<>(points);
    }
}
