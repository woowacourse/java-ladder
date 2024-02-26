package model.ladder;

import java.util.Objects;

public class Step {
    private final StepStatus status;

    private Step(final StepStatus status) {
        this.status = status;
    }

    public static Step from(StepStatus status) {
        return new Step(status);
    }

    public static Step of(Step previous, StepStatusGenerator stepStatusGenerator) {
        return new Step(stepStatusGenerator.generate(previous));
    }

    public boolean isEmpty() {
        return status.equals(StepStatus.EMPTY);
    }

    public boolean isDisconnected() {
        return status.equals(StepStatus.DISCONNECTED);
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
        return status == step.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(status);
    }
}
