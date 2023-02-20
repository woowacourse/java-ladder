package laddergame.domain.ladder;

import laddergame.domain.rung.Rungs;
import laddergame.util.BooleanGenerator;

import java.util.List;

public class Ladder {

    private final List<Rungs> ladder;

    private Ladder(final List<Rungs> ladder) {
        this.ladder = ladder;
    }

    public static Ladder create(final BooleanGenerator booleanGenerator, final String height, final int participantCount) {
        LadderFactory ladderFactory = LadderFactory.create(booleanGenerator);
        List<Rungs> ladder = ladderFactory.makeLadder(height, participantCount);
        return new Ladder(ladder);
    }

    public List<Rungs> getLadder() {
        return ladder;
    }
}
