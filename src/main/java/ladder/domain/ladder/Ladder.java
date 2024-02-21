package ladder.domain.ladder;

import ladder.domain.generator.LadderStepGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<LadderStep> ladderSteps;

    public Ladder(LadderStepGenerator stepGenerator, int stepHeight) {
        List<LadderStep> generatedLadderSteps = new ArrayList<>();
        for (int currentHeight = 0; currentHeight < stepHeight; currentHeight++) {
            LadderStep currentLadderStep = stepGenerator.generateValidStep();
            generatedLadderSteps.add(currentLadderStep);
        }
        ladderSteps = Collections.unmodifiableList(generatedLadderSteps);
    }

    public List<LadderStep> getLadderSteps() {
        return ladderSteps;
    }
}
