package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
        List<Line> lines = new ArrayList<>();

        for (int currentHeight = 0; currentHeight < height; currentHeight++) {
            Line line = new Line(playerCount, booleanGenerator);
            lines.add(line);
        }

        return lines;
    }

    public int getHeight() {
        return height.getHeight();
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
