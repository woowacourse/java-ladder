package laddergame.domain.ladder;

import laddergame.domain.rung.Rungs;

import java.util.List;

public class Ladder {

    private final List<Rungs> ladder;

    public Ladder(final List<Rungs> ladder) {
        this.ladder = ladder;
    }

    public List<Rungs> getLadder() {
        return ladder;
    }
}
