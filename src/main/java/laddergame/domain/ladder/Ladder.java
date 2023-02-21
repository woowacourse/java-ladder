package laddergame.domain.ladder;

import laddergame.domain.height.Height;
import laddergame.util.BooleanGenerator;

import java.util.List;

public class Ladder {

    public static final int DEFAULT_COUNT = 1;

    private final List<Line> ladder;

    private Ladder(final List<Line> ladder) {
        this.ladder = ladder;
    }

    public static Ladder create(final BooleanGenerator booleanGenerator, final String height, final int participantCount) {
        final Height ladderHeight = new Height(height);
        final int rungCount = makeRungCount(participantCount);
        final List<Line> lines = makeLines(booleanGenerator, ladderHeight, rungCount);
        return new Ladder(lines);
    }

    private static int makeRungCount(final int participantCount) {
        return participantCount - DEFAULT_COUNT;
    }

    private static List<Line> makeLines(final BooleanGenerator booleanGenerator, final Height ladderHeight, final int rungCount) {
        final LinesMaker linesMaker = LinesMaker.create(booleanGenerator);
        return linesMaker.makeLines(ladderHeight.getHeightNumber(), rungCount);
    }

    public List<Line> getLadder() {
        return ladder;
    }
}
