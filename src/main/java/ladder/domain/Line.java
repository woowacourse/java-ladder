package ladder.domain;

import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Line {
    private final List<StepStatus> stepStatuses;

    public Line(Supplier<Boolean> generator, final int userCount) {
        this.stepStatuses = createStepStatuses(generator, userCount);
    }

    private List<StepStatus> createStepStatuses(Supplier<Boolean> generator, final int userCount) {
        final int totalSteps = userCount - 1;
        final List<StepStatus> stepStatuses = new ArrayList<>(totalSteps);
        for (int i = 0; i < totalSteps; i++) {
            stepStatuses.add(generateStepStatus(generator, stepStatuses, i));
        }
        return stepStatuses;
    }

    private StepStatus generateStepStatus(
            Supplier<Boolean> generator,
            final List<StepStatus> stepStatuses,
            final int currentStep) {
        final int previousStep = currentStep - 1;
        if (currentStep > 0 && stepStatuses.get(previousStep).isExist()) {
            return StepStatus.getStepStatus(false);
        }
        return StepStatus.getStepStatus(generator.get());
    }

    public List<StepStatus> getLine() {
        return unmodifiableList(stepStatuses);
    }
}
