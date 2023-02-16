package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

import static laddergame.utils.ExceptionTemplate.repeat;
import static laddergame.messsages.ExceptionMessages.LINE_CREATOR_BOOLEAN_GENERATOR_NULL_EXCEPTION;
import static laddergame.messsages.ExceptionMessages.LINE_CREATOR_ILLEGAL_LENGTH_EXCEPTION;

public class LineCreator {

    private final BooleanGenerator booleanGenerator;

    public LineCreator(BooleanGenerator booleanGenerator) {
        if (booleanGenerator == null) {
            throw new IllegalArgumentException(LINE_CREATOR_BOOLEAN_GENERATOR_NULL_EXCEPTION.getMessage());
        }
        this.booleanGenerator = booleanGenerator;
    }

    public List<Line> createLines(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException(LINE_CREATOR_ILLEGAL_LENGTH_EXCEPTION.getMessage());
        }

        List<Line> lines = new ArrayList<>();
        for (int count = 0; count < height; count++) {
            Line line = repeat(() -> createLine(width));
            lines.add(line);
        }

        return lines;
    }

    private Line createLine(int width) {
        List<Boolean> points = new ArrayList<>();
        for (int count = 0; count < width; count++) {
            points.add(booleanGenerator.generate());
        }

        return new Line(points);
    }
}
