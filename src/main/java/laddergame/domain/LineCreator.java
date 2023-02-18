package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

import static laddergame.utils.RetryUtils.retryOnRuntimeException;

public class LineCreator {

    private final BooleanGenerator booleanGenerator;

    public LineCreator(final BooleanGenerator booleanGenerator) {
        validateNotNull(booleanGenerator);
        this.booleanGenerator = booleanGenerator;
    }

    public List<Line> createLines(final int width, final int height) {
        validatePositive(width, height);

        final List<Line> lines = new ArrayList<>();
        for (int count = 0; count < height; count++) {
            final Line line = retryOnRuntimeException(() -> createLine(width));
            lines.add(line);
        }

        return lines;
    }

    private Line createLine(final int width) {
        final List<Boolean> points = new ArrayList<>();
        for (int count = 0; count < width; count++) {
            points.add(booleanGenerator.generate());
        }

        return new Line(points);
    }

    private void validateNotNull(final BooleanGenerator booleanGenerator) {
        if (booleanGenerator == null) {
            throw new IllegalArgumentException("boolean generator는 null이 될 수 없습니다.");
        }
    }

    private void validatePositive(final int width, final int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("길이는 양수여야합니다.");
        }
    }
}
