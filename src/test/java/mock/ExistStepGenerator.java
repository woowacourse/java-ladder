package mock;

import domain.Step;
import domain.StepGenerator;

public class ExistStepGenerator implements StepGenerator {
    @Override
    public Step generate() {
        return Step.EXIST;
    }
}
