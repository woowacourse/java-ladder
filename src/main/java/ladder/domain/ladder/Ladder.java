package ladder.domain.ladder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import ladder.domain.ladder.generator.BooleanGenerator;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int playerCount, LadderHeight ladderHeight, BooleanGenerator booleanGenerator) {
        this.lines = generateLines(playerCount, ladderHeight.getHeight(), booleanGenerator);

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
