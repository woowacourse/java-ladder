package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LineCreator {
    private static final String LINE_WIDTH_NULL_EXCEPTION = "넓이는 null이 될 수 없습니다.";
    private static final String LINE_HEIGHT_NULL_EXCEPTION = "높이는 null이 될 수 없습니다.";

    private final BooleanGenerator booleanGenerator;

    public LineCreator(final BooleanGenerator inputGenerator) {
        this.booleanGenerator = getBooleanGenerator(inputGenerator);
    }

    public Lines createLines(final Width inputWidth, final Height inputHeight) {
        final Width width = getWidth(inputWidth);
        final Height height = getHeight(inputHeight);
        final List<Line> lines = new ArrayList<>();
        for (int count = 0; count < height.getValue(); count++) {
            final Line line = createLine(width.getValue());
            lines.add(line);
        }
        return new Lines(lines);
    }

    private Line createLine(final int width) {
        final List<Boolean> points = new ArrayList<>();
        for (int count = 0; count < width; count++) {
            boolean generatedBoolean = createNewBoolean(points);
            points.add(generatedBoolean);
        }
        return new Line(points);
    }

    private BooleanGenerator getBooleanGenerator(final BooleanGenerator inputGenerator) {
        return Optional.ofNullable(inputGenerator).orElse(new RandomBooleanGenerator());
    }

    private Height getHeight(final Height inputHeight) {
        return Optional.ofNullable(inputHeight)
                .orElseThrow(() -> new IllegalArgumentException(LINE_HEIGHT_NULL_EXCEPTION));
    }

    private Width getWidth(final Width inputWidth) {
        return Optional.ofNullable(inputWidth)
                .orElseThrow(() -> new IllegalArgumentException(LINE_WIDTH_NULL_EXCEPTION));
    }

    private boolean createNewBoolean(final List<Boolean> points) {
        boolean generatedBoolean = booleanGenerator.generate();
        if (checkLastAndNewTrue(points, generatedBoolean)) {
            return false;
        }
        return generatedBoolean;
    }

    private boolean checkLastAndNewTrue(final List<Boolean> points, final boolean isNewOneTrue) {
        if (points.isEmpty()) {
            return false;
        }
        boolean isLastOneTrue = points.get(points.size() - 1);
        return isLastOneTrue && isNewOneTrue;
    }
}
