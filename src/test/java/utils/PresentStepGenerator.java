package utils;

import domain.StepPoint;

public class PresentStepGenerator implements StepGenerator {

    public StepPoint generate() {
        return StepPoint.PRESENT;
    }
}
