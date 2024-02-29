package utils;

import domain.ladder.StepPoint;

public class PresentStepGenerator implements StepGenerator {

    public StepPoint generate() {
        return StepPoint.PRESENT;
    }
}
