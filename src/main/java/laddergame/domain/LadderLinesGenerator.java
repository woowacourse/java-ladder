package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderLinesGenerator {
    private final BooleanGenerator booleanGenerator;

    public LadderLinesGenerator(final BooleanGenerator booleanGenerator) {
        this.booleanGenerator = booleanGenerator;
    }

    public List<Line> createLines(final Width width, final Height height) {
        List<Line> lines = new ArrayList<>();
        int heightLength = height.getValue();

        while (heightLength-- > 0) {
            final Line line = createLine(width);
            lines.add(line);
        }
        return lines;
    }

    private Line createLine(final Width width) {
        while (true) {
            try {
                final List<Boolean> points = decidePointTypes(width);
                return new Line(points);
            } catch (IllegalArgumentException ignored) {
                /* IGNORED */
            }
        }
    }

    private List<Boolean> decidePointTypes(final Width width) {
        int count = width.getValue() - 1;
        final List<Boolean> doesRungExistOnPoint = new ArrayList<>();
        while (count-- > 0) {
            doesRungExistOnPoint.add(booleanGenerator.generate());
        }
        return doesRungExistOnPoint;
    }
}
