package model.ladder;

import java.util.Objects;

public class Step {
    private final StepStatus stepStatus;

    private Step(final StepStatus stepStatus) {
        this.stepStatus = stepStatus;
    }

    public static Step of(Step previous, StepStatusGenerator stepStatusGenerator) {
        StepStatus stepStatus = createStepStatus(previous, stepStatusGenerator);
        return new Step(stepStatus);
    }

    private static StepStatus createStepStatus(final Step previous, final StepStatusGenerator stepStatusGenerator) {
        if (isNotOverlapped(previous)) {
            return stepStatusGenerator.generate();
        }
        return StepStatus.DISCONNECTED;
    }

    private static boolean isNotOverlapped(final Step previous) {
        return previous.isEmpty() || previous.isDisconnected();
    }

    public static Step from(final StepStatus stepStatus) {
        return new Step(stepStatus);
    }

    public boolean isEmpty() {
        return stepStatus.equals(StepStatus.EMPTY);
    }

    public boolean isConnected() {
        return stepStatus.equals(StepStatus.CONNECTED);
    }

    public boolean isDisconnected() {
        return stepStatus.equals(StepStatus.DISCONNECTED);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Step step = (Step) o;
        return stepStatus == step.stepStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(stepStatus);
    }
}
