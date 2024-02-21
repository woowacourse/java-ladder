package ladder.domain.ladder;

import ladder.domain.generator.LadderStepGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<LadderStep> ladderSteps;

    public Ladder(final LadderStepGenerator stepGenerator, final int stepHeight) {
        final List<LadderStep> generatedLadderSteps = generateLadderSteps(stepGenerator, stepHeight);
        this.ladderSteps = Collections.unmodifiableList(generatedLadderSteps);
    }

    private List<LadderStep> generateLadderSteps(final LadderStepGenerator stepGenerator, final int stepHeight) {
        List<LadderStep> generatedLadderSteps = new ArrayList<>();
        while (generatedLadderSteps.size() < stepHeight) {
            LadderStep currentLadderStep = stepGenerator.generateValidStep();
            generatedLadderSteps.add(currentLadderStep);
        }
        return generatedLadderSteps;
    }

    public List<LadderStep> getLadderSteps() {
        return ladderSteps;
    }
}
