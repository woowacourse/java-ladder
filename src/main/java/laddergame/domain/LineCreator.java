package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LineCreator {
    private static final int WIDTH_MIN_VALUE = 1;
    private static final int HEIGHT_MIN_VALUE = 1;
    private static final String LINE_CREATOR_ILLEGAL_LENGTH_EXCEPTION = "길이는 양수여야합니다.";

    private final BooleanGenerator booleanGenerator;

    public LineCreator(final BooleanGenerator inputGenerator) {
        this.booleanGenerator = Optional.ofNullable(inputGenerator).orElse(new RandomBooleanGenerator());
    }

    public List<Line> createLines(final int width, final int height) {
        validatePositive(width, height);
        final List<Line> lines = new ArrayList<>();
        for (int count = 0; count < height; count++) {
            final Line line = createLine(width);
            lines.add(line);
        }
        return lines;
    }

    private Line createLine(final int width) {
        final List<Boolean> points = new ArrayList<>();
        for (int count = 0; count < width; count++) {
            boolean generatedBoolean = createNewBoolean(points);
            points.add(generatedBoolean);
        }
        return new Line(points);
    }

    private boolean createNewBoolean(final List<Boolean> points) {
        boolean generatedBoolean = booleanGenerator.generate();
        if (checkLastAndNewTrue(points, generatedBoolean)) {
            return false;
        }
        return generatedBoolean;
    }

    private boolean checkLastAndNewTrue(final List<Boolean> points, final boolean isNewOneTrue) {
        if (points.size() < 2) {
            return false;
        }
        boolean isLastOneTrue = points.get(points.size() - 1);
        return isLastOneTrue && isNewOneTrue;
    }

    private void validatePositive(final int width, final int height) {
        if (width < WIDTH_MIN_VALUE || height < HEIGHT_MIN_VALUE) {
            throw new IllegalArgumentException(LINE_CREATOR_ILLEGAL_LENGTH_EXCEPTION);
        }
    }
}
