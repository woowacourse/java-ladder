package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderMaker {

    private final LadderSize ladderSize;

    public LadderMaker(final LadderSize ladderSize) {
        this.ladderSize = ladderSize;
    }

    public Ladder generate(BooleanGenerator booleanGenerator) {
        List<Line> lines = new ArrayList<>();

        for (int height = 0; height < ladderSize.getHeight(); height++) {
            lines.add(new Line(ladderSize.getWidth(), booleanGenerator));
        }

        return new Ladder(lines);
    }
}
