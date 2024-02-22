package ladder.domain.ladder;

import ladder.domain.generator.BooleanGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(final int playerCount, final int height, final BooleanGenerator booleanGenerator) {
        this.lines = generateLines(playerCount, height, booleanGenerator);
    }

    private List<Line> generateLines(int playerCount, int height, BooleanGenerator booleanGenerator) {
        return Stream.generate(() -> new Line(playerCount, booleanGenerator))
                .limit(height)
                .toList();
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
