package ladder.domain.ladder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import ladder.domain.generator.BooleanGenerator;

public class Ladder {
    private final int playerCount;
    private final Height height;
    private final List<Line> lines;

    public Ladder(int playerCount, int height, BooleanGenerator booleanGenerator) {
        this.playerCount = playerCount;
        this.height = new Height(height);
        this.lines = generateLines(playerCount, height, booleanGenerator);

    }

    private List<Line> generateLines(int playerCount, int height, BooleanGenerator booleanGenerator) {
        return Stream.generate(() -> new Line(playerCount, booleanGenerator))
                .limit(height)
                .toList();
    }

    public int getHeight() {
        return height.getHeight();
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
