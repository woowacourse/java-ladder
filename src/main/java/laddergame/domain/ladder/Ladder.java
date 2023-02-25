package laddergame.domain.ladder;

import laddergame.domain.participant.Participant;
import laddergame.util.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    public static final int DEFAULT_COUNT = 1;

    private final List<Line> lines;

    public Ladder(final BooleanGenerator booleanGenerator, final String height, final int participantCount) {
        final LadderHeight ladderHeight = new LadderHeight(height);
        final int rungCount = makeRungCount(participantCount);
        this.lines = makeLines(booleanGenerator, ladderHeight.getHeight(), rungCount);
    }

    private int makeRungCount(final int participantCount) {
        return participantCount - DEFAULT_COUNT;
    }

    private List<Line> makeLines(final BooleanGenerator booleanGenerator, final int linesSize, final int lineSize) {
        List<Line> lines = new ArrayList<>();
        for (int index = 0; index < linesSize; index++) {
            lines.add(Line.create(lineSize, booleanGenerator));
        }
        return lines;
    }

    public List<Line> getLines() {
        return lines;
    }

    public void moveToDestination(final Participant participant) {
        for (Line line : lines) {
            participant.move(line);
        }
    }
}
