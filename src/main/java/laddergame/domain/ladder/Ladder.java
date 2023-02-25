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
        this.lines = makeLines(booleanGenerator, ladderHeight, rungCount);
    }

    private int makeRungCount(final int participantCount) {
        return participantCount - DEFAULT_COUNT;
    }

    private List<Line> makeLines(final BooleanGenerator booleanGenerator, final LadderHeight ladderHeight, final int rungCount) {
        List<Line> lines = new ArrayList<>();
        for (int index = 0; index < ladderHeight.getHeight(); index++) {
            lines.add(Line.create(rungCount, booleanGenerator));
        }
        return lines;
    }

    public List<Line> getLines() {
        return lines;
    }

    public void moveToDestination(final Participant participant) {
        for (Line line : lines) {
            int position = participant.getParticipantPosition();
            if (position == 0) {
                if (line.hasRung(position)) {
                    participant.moveToTheRight();
                }
                continue;
            }
            if (position == line.size()) {
                if (line.hasRung(position - 1)) {
                    participant.moveToTheLeft();
                }
                continue;
            }
            if (line.hasRung(position)) {
                participant.moveToTheRight();
                continue;
            }
            if (line.hasRung(position - 1)) {
                participant.moveToTheLeft();
            }
        }
    }
}
