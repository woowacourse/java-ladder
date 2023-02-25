package ladder.domain;

import java.util.Collections;
import java.util.List;

public class LadderGame {

    private static final int LADDER_WIDTH_CRITERIA = 1;

    private final RandomGenerator<Boolean> randomGenerator;
    private final Players players;
    private Lines lines;

    public LadderGame(final Players players, final int height) {
        this.players = players;
        this.randomGenerator = new RandomBooleanGenerator();
        initializeLines(height);
    }

    public LadderGame(final RandomGenerator<Boolean> randomGenerator, final Players players, final int height) {
        this.players = players;
        this.randomGenerator = randomGenerator;
        initializeLines(height);
    }

    private void initializeLines(final int height) {
        int width = players.size() - LADDER_WIDTH_CRITERIA;
        this.lines = new Lines(randomGenerator, height, width);
    }

    public void play() {
        for (final Line line : lines.toUnModifiableLines()) {
            players.moveAll(line);
        }
    }

    public List<Line> getUnmodifiableLines() {
        return Collections.unmodifiableList(lines.toUnModifiableLines());
    }
}
