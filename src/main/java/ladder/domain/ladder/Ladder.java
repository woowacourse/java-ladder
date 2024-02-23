package ladder.domain.ladder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import ladder.domain.ladder.generator.RungGenerator;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int playerCount, LadderHeight ladderHeight, RungGenerator rungGenerator) {
        this.lines = generateLines(playerCount, ladderHeight.getHeight(), rungGenerator);

    }

    private List<Line> generateLines(int playerCount, int height, RungGenerator rungGenerator) {
        return Stream.generate(() -> new Line(playerCount, rungGenerator))
                .limit(height)
                .toList();
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
