package model.ladder.generator;

import model.ladder.StepStatus;

public class TestStepStatusGenerator {

    public static class AlwaysConnectStatusGenerator implements StepStatusGenerator {

        @Override
        public StepStatus generate() {
            return StepStatus.CONNECTED;
        }
    }

    public static class AlwaysDisconnectStatusGenerator implements StepStatusGenerator {

        @Override
        public StepStatus generate() {
            return StepStatus.DISCONNECTED;
        }
    }
}
