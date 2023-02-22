package ladder.domain;

import java.util.List;

public class Ladder {
    private final List<Row> ladder;

    private Ladder(List<Row> ladder) {
        this.ladder = ladder;
    }

    public static Ladder from(LadderGenerator ladderGenerator){
        return new Ladder(ladderGenerator.generateLadder());
    }

    public List<Row> getLadder() {
        return ladder;
    }
}
