package ladder.domain;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Ladder {

    private final List<Line> lines;

    private Ladder(final List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder generate(final BooleanGenerator booleanGenerator, final int height, final int width) {
        return Stream.generate(() -> Line.generate(booleanGenerator, width))
                .limit(height)
                .collect(collectingAndThen(toList(), Ladder::new));
    }

    public Position play(final Position position) {
        Position currentPosition = position;
        for (Line line : lines) {
            currentPosition = line.play(currentPosition);
        }
        return currentPosition;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
