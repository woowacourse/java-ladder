package model.ladder.generator;

import model.ladder.StepStatus;

public class AlwaysDisconnectStatusGenerator implements StepStatusGenerator {

    @Override
    public StepStatus generate() {
        return StepStatus.DISCONNECTED;
    }
}
