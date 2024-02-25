package mock;

import domain.Step;
import domain.StepGenerator;

public class EmptyStepGenerator implements StepGenerator {
    @Override
    public Step generate() {
        return Step.EMPTY;
    }
}
