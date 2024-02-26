package ladder.domain.generator;

import ladder.domain.ladder.LadderStep;

public interface LadderStepGenerator {
    LadderStep generate(final int stepWidth);
}
