package ladder.domain.ladder;

import ladder.domain.generator.LadderStepGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<LadderStep> ladderSteps;

    public Ladder(final LadderStepGenerator stepGenerator, final Height height) {
        final List<LadderStep> generatedLadderSteps = generateLadderSteps(stepGenerator, height);
        this.ladderSteps = Collections.unmodifiableList(generatedLadderSteps);
    }

    private List<LadderStep> generateLadderSteps(final LadderStepGenerator stepGenerator, final Height height) {
        List<LadderStep> ladderSteps = new ArrayList<>();
        while (height.isGreaterThan(ladderSteps)) {
            LadderStep currentLadderStep = stepGenerator.generateValidStep();
            ladderSteps.add(currentLadderStep);
        }
        return ladderSteps;
    }

    public List<LadderStep> getLadderSteps() {
        return ladderSteps;
    }
}
