package mock;

import domain.ladder.Step;
import domain.ladder.StepGenerator;

public class EmptyStepGenerator implements StepGenerator {
    @Override
    public Step generate() {
        return Step.EMPTY;
    }
}
