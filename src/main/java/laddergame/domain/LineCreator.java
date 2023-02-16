package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

import static laddergame.ExceptionTemplate.repeat;
public class LineCreator {

    private final BooleanGenerator booleanGenerator;

    public LineCreator(BooleanGenerator booleanGenerator) {
        if (booleanGenerator == null) {
            throw new IllegalArgumentException();
        }
        this.booleanGenerator = booleanGenerator;
    }

    public List<Line> createLines(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException();
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
