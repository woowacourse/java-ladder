package model.ladder.generator;

import model.ladder.StepStatus;

public class AlwaysConnectStatusGenerator implements StepStatusGenerator {

    @Override
    public StepStatus generate() {
        return StepStatus.CONNECTED;
    }
}
