package ladder.domain.ladder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import ladder.domain.ladder.generator.BooleanGenerator;

public class Ladder {
    private final int playerCount;
    private final LadderHeight ladderHeight;
    private final List<Line> lines;

    public Ladder(final int playerCount, final LadderHeight ladderHeight, final BooleanGenerator booleanGenerator) {
        this.playerCount = playerCount;
        this.ladderHeight = ladderHeight;
        this.lines = generateLines(playerCount, ladderHeight.getHeight(), booleanGenerator);

    }

    private List<Line> generateLines(int playerCount, int height, BooleanGenerator booleanGenerator) {
        return Stream.generate(() -> new Line(playerCount, booleanGenerator))
                .limit(height)
                .toList();
    }

    public int getHeight() {
        return ladderHeight.getHeight();
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
