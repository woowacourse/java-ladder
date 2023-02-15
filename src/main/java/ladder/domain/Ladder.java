package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ladder.domain.generator.LineGenerator;

public class Ladder {

    private final List<Line> lines;

    public Ladder(final LineGenerator lineGenerator, final int numberOfPlayers, final int height) {
        this.lines = generateLines(lineGenerator, numberOfPlayers, height);
    }

    private List<Line> generateLines(final LineGenerator lineGenerator, final int numberOfPlayers, final int height) {
        final List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(lineGenerator.generate(numberOfPlayers));
        }
        return lines;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}

