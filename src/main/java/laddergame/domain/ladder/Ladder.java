package laddergame.domain.ladder;

import laddergame.domain.rung.Rungs;

import java.util.List;

public class Ladder {

    private final List<Rungs> ladder;

    private Ladder(final List<Rungs> ladder) {
        this.ladder = ladder;
    }

    public static Ladder create(final List<Rungs> ladder) {
        return new Ladder(ladder);
    }

    public List<Rungs> getLadder() {
        return ladder;
    }
}
