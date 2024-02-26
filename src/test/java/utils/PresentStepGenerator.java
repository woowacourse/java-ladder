package utils;

import domain.StepGenerator;
import domain.StepPoint;

public class PresentStepGenerator implements StepGenerator {

    public StepPoint generate() {
        return StepPoint.PRESENT;
    }
}
