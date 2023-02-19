package laddergame.domain.ladder;

import laddergame.domain.rung.Rungs;
import laddergame.util.BooleanGenerator;

import java.util.List;

public class Ladder {

    private final List<Rungs> ladderRungs;

    private Ladder(final List<Rungs> ladderRungs) {
        this.ladderRungs = ladderRungs;
    }

    public static Ladder create(final String height, final int participantCount, final BooleanGenerator rungGenerator) {
        List<Rungs> ladderRungs = LadderFactory.getInstance(rungGenerator).createLadderRungs(height, participantCount);
        return new Ladder(ladderRungs);
    }

    public List<Rungs> getLadderRungs() {
        return List.copyOf(ladderRungs);
    }
}
