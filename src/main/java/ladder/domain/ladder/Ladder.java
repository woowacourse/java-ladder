package ladder.domain.ladder;

import ladder.domain.Direction;
import ladder.domain.Position;
import ladder.domain.generator.LadderStepsGenerator;
import ladder.domain.ladder.size.LadderSize;
import ladder.domain.participant.Participant;

import java.util.List;

import static java.util.Collections.unmodifiableList;

public class Ladder {
    private final List<LadderStep> ladderSteps;

    public Ladder(final LadderSize ladderSize, final LadderStepsGenerator ladderStepsGenerator) {
        final List<LadderStep> generatedLadderSteps = ladderStepsGenerator.generate(ladderSize);
        this.ladderSteps = unmodifiableList(generatedLadderSteps);
    }

    public List<LadderStep> getLadderSteps() {
        return ladderSteps;
    }

    public Position determineFinalPositionOf(final Participant participant) {
        Position currentPosition = participant.getStartPosition();
        for (LadderStep ladderStep : ladderSteps) {
            final Direction direction = ladderStep.getNextDirection(currentPosition);
            currentPosition = direction.determineNextPosition(currentPosition);
        }
        return currentPosition;
    }
}
