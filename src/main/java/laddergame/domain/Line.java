package laddergame.domain;

import static laddergame.domain.Point.of;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private final List<Point> points = new ArrayList<>();

    public Line(final List<Boolean> rungExistsAtPoint) {
        validate(rungExistsAtPoint);
        for (final Boolean isFilled : rungExistsAtPoint) {
            points.add(of(isFilled));
        }
    }

    private void validate(final List<Boolean> points) {
        if (points.isEmpty()) {
            throw new IllegalArgumentException("사다리의 가로는 한 칸 이상이어야합니다.");
        }
        if (hasAdjacentRung(points)) {
            throw new IllegalArgumentException("사다리의 가로 라인은 겹칠 수 없습니다.");
        }
    }

    private static boolean hasAdjacentRung(List<Boolean> rungExistsAtColumn) {
        return IntStream.range(0, rungExistsAtColumn.size() - 1)
                .anyMatch(pointIndex -> rungExistsAtColumn.get(pointIndex) && rungExistsAtColumn.get(pointIndex + 1));
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
