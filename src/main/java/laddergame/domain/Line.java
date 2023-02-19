package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Line {
    private static final String LINE_POINTS_EMPTY_EXCEPTION = "boolean 리스트는 비어있을 수 없습니다.";

    private final List<Boolean> points;

    public Line(final List<Boolean> inputPoints) {
        final List<Boolean> points = Optional.ofNullable(inputPoints).orElse(List.of());
        validatePoints(points);
        this.points = points;
    }

    private void validatePoints(final List<Boolean> points) {
        if (points.isEmpty()) {
            throw new IllegalArgumentException(LINE_POINTS_EMPTY_EXCEPTION);
        }
    }

    public List<Boolean> getPoints() {
        return new ArrayList<>(points);
    }
}
