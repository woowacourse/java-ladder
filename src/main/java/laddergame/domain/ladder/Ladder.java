package laddergame.domain.ladder;

import laddergame.util.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    public Ladder(final BooleanGenerator booleanGenerator, final String height, final int participantCount) {
        final LadderHeight ladderHeight = new LadderHeight(height);
        this.lines = makeLines(booleanGenerator, ladderHeight.getHeight(), participantCount);
    }

    private List<Line> makeLines(final BooleanGenerator booleanGenerator, final int linesSize, final int participantCount) {
        List<Line> lines = new ArrayList<>();
        for (int index = 0; index < linesSize; index++) {
            lines.add(Line.create(participantCount, booleanGenerator));
        }
        return lines;
    }

    public List<Line> getLines() {
        return lines;
    }
}
