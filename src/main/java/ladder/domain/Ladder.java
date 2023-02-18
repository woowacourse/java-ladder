package ladder.domain;

import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class Ladder {

    private final List<Line> lines;

    public Ladder(final BooleanGenerator booleanGenerator, final int height, final int width) {
        this.lines = generateLines(booleanGenerator, height, width);
    }

    private Ladder(final List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder generate(final BooleanGenerator booleanGenerator, final int height, final int width) {
        return new Ladder(generateLines(booleanGenerator, height, width));
    }

    private static List<Line> generateLines(final BooleanGenerator generator, final int height, final int width) {
        return Stream.generate(() -> Line.generate(generator, width))
                .limit(height)
                .collect(toList());
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
