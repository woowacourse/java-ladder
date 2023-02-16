package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

import static laddergame.messsages.ExceptionMessages.LINE_CREATOR_BOOLEAN_GENERATOR_NULL_EXCEPTION;
import static laddergame.messsages.ExceptionMessages.LINE_CREATOR_ILLEGAL_LENGTH_EXCEPTION;
import static laddergame.utils.ExceptionTemplate.repeat;

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
            throw new IllegalArgumentException(LINE_CREATOR_BOOLEAN_GENERATOR_NULL_EXCEPTION.getMessage());
        }
    }

    private void validatePositive(final int width, final int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException(LINE_CREATOR_ILLEGAL_LENGTH_EXCEPTION.getMessage());
        }
    }
}
