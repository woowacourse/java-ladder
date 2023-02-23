package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

import static laddergame.utils.OptionalUtils.getValueAfterNullCheck;

public class Line {
    private static final String LINE_POINTS_EMPTY_EXCEPTION = "boolean 리스트는 비어있을 수 없습니다.";

    private final List<Boolean> points;

    public Line(final List<Boolean> inputPoints) {
        final List<Boolean> points = getValueAfterNullCheck(inputPoints);
        validatePoints(points);
        this.points = points;
    }

    public boolean getPointByPosition(final Position position) {
        return points.get(position.getValue());
    }

    public Width getWidth() {
        return new Width(points.size());
    }

    public List<Boolean> getPoints() {
        return new ArrayList<>(points);
    }

    private void validatePoints(final List<Boolean> points) {
        if (points.isEmpty()) {
            throw new IllegalArgumentException(LINE_POINTS_EMPTY_EXCEPTION);
        }
    }
}
