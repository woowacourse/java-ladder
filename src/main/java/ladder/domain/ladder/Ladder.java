package ladder.domain.ladder;

import ladder.domain.Direction;
import ladder.domain.Position;
import ladder.domain.generator.LadderStepsGenerator;
import ladder.domain.participant.Participant;

import java.util.List;

import static java.util.Collections.unmodifiableList;

public class Ladder {
    private final List<LadderStep> ladderSteps;

    public Ladder(final LadderStepsGenerator ladderStepsGenerator) {
        this.ladderSteps = unmodifiableList(ladderStepsGenerator.generate());
    }

    public List<LadderStep> getLadderSteps() {
        return ladderSteps;
    }

    public Position determineFinalPositionOf(Participant participant) {
        Position currentPosition = participant.getStartPosition();
        for (LadderStep ladderStep : ladderSteps) {
            Direction direction = ladderStep.getNextDirection(currentPosition);
            currentPosition = direction.determineNextPosition(currentPosition);
        }
        return currentPosition;
    }
}
