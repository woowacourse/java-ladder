package ladder.domain.ladder;

import ladder.domain.generator.LadderStepGenerator;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public class Ladder {
    private final List<LadderStep> ladderSteps;

    public Ladder(final LadderStepGenerator stepGenerator, final Height height) {
        this.ladderSteps = generateLadderSteps(stepGenerator, height);
    }

    private List<LadderStep> generateLadderSteps(final LadderStepGenerator stepGenerator, final Height height) {
        final List<LadderStep> ladderSteps = new ArrayList<>();
        while (height.isGreaterThan(ladderSteps.size())) {
            final LadderStep currentLadderStep = stepGenerator.generateValidStep();
            ladderSteps.add(currentLadderStep);
        }
        return ladderSteps;
    }

    public List<LadderStep> getLadderSteps() {
        return unmodifiableList(ladderSteps);
    }
}
