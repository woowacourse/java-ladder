package ladder.domain;

import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class Ladder {

    private static final String INVALID_HEIGHT_MESSAGE = "사다리 높이는 최소 1, 최대 100까지 가능합니다.";
    private final List<Line> lines;

    public Ladder(final BooleanGenerator booleanGenerator, final int height, final int width) {
        validateHeight(height);
        this.lines = generateLines(booleanGenerator, height, width);
    }

    private void validateHeight(final int height) {
        if (height < 1 || height > 100) {
            throw new IllegalArgumentException(INVALID_HEIGHT_MESSAGE);
        }
    }

    private List<Line> generateLines(final BooleanGenerator booleanGenerator, final int height, final int width) {
        return Stream.generate(() -> new Line(booleanGenerator, width))
                .limit(height)
                .collect(toList());
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
