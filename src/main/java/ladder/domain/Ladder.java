package ladder.domain;

import java.util.List;

public class Ladder {
    private final List<Row> ladder;

    public Ladder(List<Row> ladder) {
        this.ladder = ladder;
    }

    public List<Row> getLadder() {
        return ladder;
    }
}
