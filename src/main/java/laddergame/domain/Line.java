package laddergame.domain;

import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private final List<Boolean> rungExistsAtEachColumn;

    public Line(final List<Boolean> rungExistsAtColumn) {
        validate(rungExistsAtColumn);
        this.rungExistsAtEachColumn = rungExistsAtColumn;
    }

    private void validate(final List<Boolean> points) {
        if (points.isEmpty()) {
            throw new IllegalArgumentException("boolean 리스트는 비어있을 수 없습니다.");
        }
        if (hasAdjacentRung(points)) {
            throw new IllegalArgumentException("사다리의 가로 라인은 겹칠 수 없습니다.");
        }
    }

    private static boolean hasAdjacentRung(List<Boolean> rungExistsAtColumn) {
        return IntStream.range(0, rungExistsAtColumn.size() - 1)
                .anyMatch(pointIndex -> rungExistsAtColumn.get(pointIndex) && rungExistsAtColumn.get(pointIndex + 1));
    }

    public List<Boolean> getRungExistsAtEachColumn() {
        return rungExistsAtEachColumn;
    }
}
