package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

import static laddergame.utils.ExceptionTemplate.repeat;

public class LineCreator {
    private static final int WIDTH_MIN_VALUE = 1;
    private static final int HEIGHT_MIN_VALUE = 1;
    private static final String LINE_CREATOR_BOOLEAN_GENERATOR_NULL_EXCEPTION = "boolean generator는 null이 될 수 없습니다.";
    private static final String LINE_CREATOR_ILLEGAL_LENGTH_EXCEPTION = "길이는 양수여야합니다.";

    private final BooleanGenerator booleanGenerator;

    public LineCreator(final BooleanGenerator booleanGenerator) {
        validateNotNull(booleanGenerator);
        this.booleanGenerator = booleanGenerator;
    }

    public List<Line> createLines(final int width, final int height) {
        validatePositive(width, height);

        final List<Line> lines = new ArrayList<>();
        for (int count = 0; count < height; count++) {
            final Line line = repeat(() -> createLine(width));
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
            throw new IllegalArgumentException(LINE_CREATOR_BOOLEAN_GENERATOR_NULL_EXCEPTION);
        }
    }

    private void validatePositive(final int width, final int height) {
        if (width < WIDTH_MIN_VALUE || height < HEIGHT_MIN_VALUE) {
            throw new IllegalArgumentException(LINE_CREATOR_ILLEGAL_LENGTH_EXCEPTION);
        }
    }
}
