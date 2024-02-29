package ladder.domain;

import java.util.Arrays;

import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Point> points;

    public Line(Direction... directions) {
        this(Arrays.stream(directions)
                .map(Point::new)
                .toList());
    }

    public Line(List<Point> points) {
//        validate(points);
        this.points = points;
    }

    private void validate(List<Point> points) {
        validateAtLeastOnePointIsUsed(points);
        validateNonConsecutiveUsage(points);
    }

    private void validateAtLeastOnePointIsUsed(List<Point> points) {
//        boolean allPointsAreUnused = points.stream().noneMatch(Point::isUsed);
//
//        if (allPointsAreUnused) {
//            throw new IllegalArgumentException("모든 좌표가 사용되지 않아 최대 사다리 높이를 만족할 수 없습니다.");
//        }
    }

    private void validateNonConsecutiveUsage(List<Point> points) {
//        boolean hasConsecutiveUsage = IntStream.range(1, points.size())
//                .anyMatch(index -> points.get(index).isSame(index - 1) && points.get(index - 1).isUsed());
//
//        if (hasConsecutiveUsage) {
//            throw new IllegalArgumentException("사다리 타기가 정상적으로 동작하려면 좌표가 연속적으로 사용되어서는 안 됩니다.");
//        }
    }

    public Index move(Index index) {
        return points.get(index.getValue()).move(index);
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
