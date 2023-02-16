package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderMaker {

    private final LadderSize ladderSize;
    private final BooleanGenerator booleanGenerator;

    public LadderMaker(final LadderSize ladderSize, final BooleanGenerator booleanGenerator) {
        this.ladderSize = ladderSize;
        this.booleanGenerator = booleanGenerator;
    }

    public Ladder generate() {
        List<Line> lines = new ArrayList<>();

        for (int height = 0; height < ladderSize.getHeight(); height++) {
            lines.add(new Line(ladderSize.getWidth(), booleanGenerator));
        }

        return new Ladder(lines);
    }
}
