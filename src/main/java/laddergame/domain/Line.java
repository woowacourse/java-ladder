package laddergame.domain;

import java.util.List;
import java.util.stream.IntStream;
import laddergame.exception.LadderLineOverlappedException;

public class Line {

    private final List<Boolean> points;

    private Line(final BooleanGenerator booleanGenerator) {
        final List<Boolean> points = booleanGenerator.generate();
        validateOverlap(points);

        this.points = points;
    }

    public static Line create(final BooleanGenerator booleanGenerator) {
        return new Line(booleanGenerator);
    }

    private void validateOverlap(final List<Boolean> points) {
        if (isOverlap(points)) {
            throw new LadderLineOverlappedException("[ERROR] 가로 라인이 겹치면 안됩니다.");
        }
    }

    private static boolean isOverlap(final List<Boolean> points) {
        return IntStream.range(0, points.size() - 1)
                .anyMatch(i -> points.get(i) && points.get(i + 1));
    }

    public List<Boolean> getPoints() {
        return points;
    }



    public int getSize() {
        return points.size();
    }
}
