package laddergame.domain;

import java.util.List;
import java.util.stream.IntStream;

import static laddergame.messsages.ExceptionMessages.LINE_POINTS_BOTH_TRUE_EXCEPTION;
import static laddergame.messsages.ExceptionMessages.LINE_POINTS_EMPTY_EXCEPTION;

public class Line {
    private final List<Boolean> points;

    public Line(final List<Boolean> points) {
        if (points.isEmpty()) {
            throw new IllegalArgumentException(LINE_POINTS_EMPTY_EXCEPTION.getMessage());
        }
        boolean isBothTrue = IntStream.range(0, points.size() - 1)
                .anyMatch(pointIndex -> points.get(pointIndex) && points.get(pointIndex + 1));
        if (isBothTrue) {
            throw new IllegalArgumentException(LINE_POINTS_BOTH_TRUE_EXCEPTION.getMessage());
        }
        this.points = points;
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
