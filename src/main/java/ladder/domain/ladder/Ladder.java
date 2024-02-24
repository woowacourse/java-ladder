package ladder.domain.ladder;

import ladder.domain.generator.RandomLadderStepGenerator;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public class Ladder {
    private final List<LadderStep> ladderSteps;

    public Ladder(final Height height, final int stepWidth) {
        this.ladderSteps = generateLadderSteps(height, stepWidth);
    }

    private List<LadderStep> generateLadderSteps(final Height height, final int stepWidth) {
        final List<LadderStep> ladderSteps = new ArrayList<>();
        while (height.isGreaterThan(ladderSteps.size())) {
            final LadderStep currentLadderStep = RandomLadderStepGenerator.generate(stepWidth);
            ladderSteps.add(currentLadderStep);
        }
        return ladderSteps;
    }

    public List<LadderStep> getLadderSteps() {
        return unmodifiableList(ladderSteps);
    }
}
