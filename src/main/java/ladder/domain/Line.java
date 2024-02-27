package ladder.domain;

import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Line {
    private final List<StepStatus> stepStatuses;

    public Line(Supplier<Boolean> stepGenerator, final int userCount) {
        this.stepStatuses = createStepStatuses(stepGenerator, userCount);
    }

    private List<StepStatus> createStepStatuses(Supplier<Boolean> stepGenerator, final int userCount) {
        final int totalSteps = userCount - 1;
        final List<StepStatus> stepStatuses = new ArrayList<>(totalSteps);
        for (int i = 0; i < totalSteps; i++) {
            stepStatuses.add(generateStepStatus(stepGenerator, stepStatuses, i));
        }
        return stepStatuses;
    }

    private StepStatus generateStepStatus(
            Supplier<Boolean> stepGenerator,
            final List<StepStatus> stepStatuses,
            final int currentStep) {
        final int previousStep = currentStep - 1;
        if (currentStep > 0 && stepStatuses.get(previousStep).isExist()) {
            return StepStatus.getStepStatus(false);
        }
        return StepStatus.getStepStatus(stepGenerator.get());
    }

    public List<Integer> findStepPosition() {
        return IntStream.range(0, stepStatuses.size())
                .filter(i -> stepStatuses.get(i).isExist())
                .boxed()
                .toList();
    }

    public List<StepStatus> getLine() {
        return unmodifiableList(stepStatuses);
    }
}
