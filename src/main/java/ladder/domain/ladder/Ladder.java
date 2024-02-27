package ladder.domain.ladder;

import ladder.domain.generator.LadderStepGenerator;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public class Ladder {
    private final List<LadderStep> ladderSteps;

    public Ladder(
            final Height height,
            final int stepWidth,
            final LadderStepGenerator ladderStepGenerator) {
        final List<LadderStep> generatedLadderSteps = generateLadderSteps(height, stepWidth, ladderStepGenerator);
        this.ladderSteps = unmodifiableList(generatedLadderSteps);
    }

    private List<LadderStep> generateLadderSteps(
            final Height height,
            final int stepWidth,
            final LadderStepGenerator ladderStepGenerator) {
        final List<LadderStep> ladderSteps = new ArrayList<>();
        while (height.isGreaterThan(ladderSteps.size())) {
            final LadderStep currentLadderStep = ladderStepGenerator.generate(stepWidth);
            ladderSteps.add(currentLadderStep);
        }
        return ladderSteps;
    }

    public int playFrom(int startPosition) {
        int nextPosition = -1;
        for (LadderStep step: ladderSteps) {
            nextPosition = step.findNextParticipantPosition(startPosition);
            startPosition = nextPosition;
        }
        return nextPosition;
    }

    public List<LadderStep> getLadderSteps() {
        return ladderSteps;
    }
}
