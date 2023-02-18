package laddergame.domain.ladder;

import laddergame.domain.rung.Rungs;

import java.util.List;

public class Ladder {

    private final List<Rungs> ladderRungs;

    private Ladder(final List<Rungs> ladderRungs) {
        this.ladderRungs = ladderRungs;
    }

    protected static Ladder create(final List<Rungs> ladderRungs) {
        return new Ladder(ladderRungs);
    }

    public List<Rungs> getLadderRungs() {
        return List.copyOf(ladderRungs);
    }
}
