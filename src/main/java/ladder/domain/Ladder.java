package ladder.domain;

import java.util.List;

public class Ladder {
    private final List<FootBars> ladder;

    public Ladder(List<FootBars> ladder) {
        this.ladder = ladder;
    }

    public List<FootBars> getLadder() {
        return ladder;
    }
}
