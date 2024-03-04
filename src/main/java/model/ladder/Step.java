package model.ladder;

import static model.ladder.StepStatus.CONNECTED;
import static model.ladder.StepStatus.DISCONNECTED;

import java.util.Objects;
import model.ladder.generator.StepStatusGenerator;

public class Step {
    private final StepStatus stepStatus;

    private Step(final StepStatus stepStatus) {
        this.stepStatus = stepStatus;
    }

    public static Step of(Step previous, StepStatusGenerator stepStatusGenerator) {
        StepStatus stepStatus = createStepStatus(previous, stepStatusGenerator);
        return new Step(stepStatus);
    }

    private static StepStatus createStepStatus(final Step previous,
                                               final StepStatusGenerator stepStatusGenerator) {
        if (isNotOverlapped(previous)) {
            return stepStatusGenerator.generate();
        }
        return DISCONNECTED;
    }

    private static boolean isNotOverlapped(final Step previous) {
        return previous.isEmpty() || previous.isDisconnected();
    }

    public static Step from(final StepStatus stepStatus) {
        return new Step(stepStatus);
    }

    public boolean isEmpty() {
        return stepStatus.isMatched(StepStatus.EMPTY);
    }

    public boolean isDisconnected() {
        return stepStatus.isMatched(DISCONNECTED);
    }

    public boolean isConnected() {
        return stepStatus.isMatched(CONNECTED);
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

    public StepStatus getStatus() {
        return stepStatus;
    }
}
