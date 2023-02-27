package domain.generator;

import domain.ladder.LadderStep;

public class NoneLadderStepGenerator implements LadderStepGenerator {
    @Override
    public LadderStep generate() {
        return LadderStep.NONE;
    }
}
