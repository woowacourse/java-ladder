package laddergame.domain.ladder;

import laddergame.domain.rung.Line;
import laddergame.util.BooleanGenerator;

import java.util.List;

public class Ladder {

    private final List<Line> ladder;

    private Ladder(final List<Line> ladder) {
        this.ladder = ladder;
    }

    public static Ladder create(final BooleanGenerator booleanGenerator, final String height, final int participantCount) {
        LadderFactory ladderFactory = LadderFactory.create(booleanGenerator);
        List<Line> ladder = ladderFactory.makeLadder(height, participantCount);
        return new Ladder(ladder);
    }

    public List<Line> getLadder() {
        return ladder;
    }
}
