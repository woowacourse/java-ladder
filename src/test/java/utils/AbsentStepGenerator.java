package utils;

import domain.StepGenerator;
import domain.StepPoint;

public class AbsentStepGenerator implements StepGenerator {

    public StepPoint generate() {
        return StepPoint.ABSENT;
    }
}
