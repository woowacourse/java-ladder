package mock;

import domain.ladder.Step;
import domain.ladder.StepGenerator;

public class ExistStepGenerator implements StepGenerator {
    @Override
    public Step generate() {
        return Step.EXIST;
    }
}
