package ladder.domain.ladder;

import ladder.domain.generator.LadderStepsGenerator;

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
}
