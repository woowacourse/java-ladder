package domain.generator;

import domain.ladder.LadderStep;

public class ExistsLadderStepGenerator implements LadderStepGenerator {

    @Override
    public LadderStep generate() {
        return LadderStep.EXISTS;
    }
}
