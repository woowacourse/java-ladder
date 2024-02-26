package ladder.testutil;

import ladder.domain.generator.LadderStepsGenerator;
import ladder.domain.ladder.LadderStep;

import java.util.List;

public record TestLadderStepsGenerator(List<LadderStep> ladderSteps) implements LadderStepsGenerator {
    @Override
    public List<LadderStep> generate() {
        return ladderSteps;
    }
}
