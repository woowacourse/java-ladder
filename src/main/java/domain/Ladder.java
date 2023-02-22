package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final Height height;
    private final Width width;
    private final List<Line> ladder;

    public Ladder(Height height, Width width, LadderGenerator randomLadderGenerator) {
        this.height = height;
        this.width = width;
        this.ladder = randomLadderGenerator.generate(width, height);
    }

    public List<Line> getLadder() {
        return new ArrayList<>(ladder);
    }
}
