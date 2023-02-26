package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> ladder;

    public Ladder(final Height height, final Width width, final LadderGenerator randomLadderGenerator) {
        this.ladder = randomLadderGenerator.generate(width, height);
    }

    public List<Line> getLadder() {
        return new ArrayList<>(ladder);
    }
}
